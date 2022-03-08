package com.jay.currency

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jay.currency.data_model.CurrencyRate
import com.jay.currency.data_model.CurrencyRateResponse
import com.jay.currency.data_model.SupportCurrency
import com.jay.currency.data_model.SupportCurrencyResponse
import com.jay.currency.repos.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.IllegalArgumentException

class MainViewModel @ViewModelInject constructor(private val repository: MainRepository) : ViewModel() {

    private val TAG = javaClass.simpleName

    val currencyRateList = repository.rateList
    val supportCurrencyList = repository.supportedCurrencyList
    val supportAbbrCurList = repository.supportAbbrCurrencyList

    var calculatedRateList : MutableLiveData<List<CurrencyRate>> = MutableLiveData(emptyList())

    // user's selection
    private var selectedCurrency : String = Const.BASE_CURRENCY
    private var amountOfMoney : Double = 1.0

    var isUpdatingUI : MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        refresh()
    }


    fun updateAmountOfMoney(amount : Double) {
        amountOfMoney = amount
        refresh()
    }

    fun updateSelectedCurrency(selectedCurrency : String) {
        if (selectedCurrency.isBlank()) {
            this.selectedCurrency = Const.BASE_CURRENCY
        }
        refresh()
    }


    fun refresh() {
        isUpdatingUI.postValue(true)
        //1. check timestamp
        val lastTimeStamp = repository.getTimeStamp(Const.APP_NAME)
        val currentTime = System.currentTimeMillis()

//        val lastTime = (currentTime - lastTimeStamp) / 1000
//        val lastTime = 3000
        val lastTime = 100
        // if (more than 30nmin) -> download and update UI else no only update UI
        if (lastTime > 1800) {
            if (downloadDataFromRemote()) {
                repository.setTimeStamp(Const.APP_NAME, System.currentTimeMillis())
            }
        }
        else {

            updateUIData()
        }



    }

    private fun downloadDataFromRemote() : Boolean {

        var isRateDownloadSuccess = false
        var isCurrencyListDownloadSuccess = false

        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val rateData = repository.downloadRateListFromRemote(Const.API_KEY)
                if (rateData.isSuccessful) {
                    // save currency rate data
                    saveCurrencyRateData(rateData.body()!!)
                    isRateDownloadSuccess = true

                }

                // download support currency
                val supportCurrencyData = repository.downloadSupportCurrencyListFromRemote(Const.API_KEY)
                if (supportCurrencyData.isSuccessful) {
                    saveSupportCurrencyData(supportCurrencyData.body()!!)
                    isCurrencyListDownloadSuccess = true
                }


                updateUIData()
            }
        }
        return isRateDownloadSuccess && isCurrencyListDownloadSuccess
    }

    private suspend fun saveCurrencyRateData(response: CurrencyRateResponse) {

        // 2. remove table
        repository.deleteCurrencyRateItem()
        // 3. Process Quotes data
        val quotesItem = response.quotes
        // 4. put into the db
        if (response.quotes != null) {
            quotesItem.map {
                val key = it.key.substring(3)
                val value = it.value
                val currencyRateItem = CurrencyRate(key, value)
                val result = repository.insertCurrencyRateItem(currencyRateItem)
                Log.d(TAG, "insert rate item result : $result")
            }
        }


    }

    private suspend fun saveSupportCurrencyData(response : SupportCurrencyResponse) {
        // 1. remove table
        repository.deleteSupportCurrencyItem()

        // 2. Process Currency Data
        val currencyItems = response.currencies
        // 3. Put them into db
        if (currencyItems != null) {
            currencyItems.map {
                repository.insertSupportCurrencyItem(SupportCurrency( it.key, it.value))
            }
        }
    }


    fun updateUIData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var tempList = mutableListOf<CurrencyRate>()
                currencyRateList.value?.map {
                    if (selectedCurrency == Const.BASE_CURRENCY) {
                        val calculatedAmount = it.rate* amountOfMoney
                        tempList.add(CurrencyRate(it.code, calculatedAmount))
                    }
                    else {

                    }
                }
                calculatedRateList.postValue(tempList)
                val test = supportCurrencyList.value
                test?.map {
                    it
                }
                isUpdatingUI.postValue(false)
            }
        }

    }
}


class MainViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}