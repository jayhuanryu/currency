package com.jay.currency.repos

import com.jay.currency.data_model.CurrencyRate
import com.jay.currency.data_model.SupportCurrency


class MainRepository(private val mainDao : MainDao, private val sharedPreferenceStorage: SharedPreferenceStorage, private val remoteSourceInterface : RemoteSourcesInterface) {


    private val TAG = javaClass.simpleName

    // db
    val rateList = mainDao.getCurrencyRateList()
    val supportedCurrencyList = mainDao.getSupportCurrencyList()
    val supportAbbrCurrencyList = mainDao.getSupportCurrencyAbbrList()

    suspend fun insertCurrencyRateItem(item : CurrencyRate) = mainDao.insertCurrencyRate(item)
    suspend fun deleteCurrencyRateItem() = mainDao.deleteCurrencyRateTable()

    suspend fun insertSupportCurrencyItem(item : SupportCurrency) = mainDao.insertSupportCurrencyItem(item)
    suspend fun deleteSupportCurrencyItem() = mainDao.deleteSupportCurrencyTable()

    fun setTimeStamp(key : String, stamp: Long) = sharedPreferenceStorage.setTimeStamp(key, stamp)
    fun getTimeStamp(key : String) : Long = sharedPreferenceStorage.getTimeStamp(key)



    // remote
    suspend fun downloadRateListFromRemote(accessKey : String) = remoteSourceInterface.getCurrencyRateList(accessKey)
    suspend fun downloadSupportCurrencyListFromRemote(accessKey: String) = remoteSourceInterface.getSupportedCurrency(accessKey)




}