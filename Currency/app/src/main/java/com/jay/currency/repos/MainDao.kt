package com.jay.currency.repos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jay.currency.data_model.CurrencyRate
import com.jay.currency.data_model.SupportCurrency


@Dao
interface MainDao {

    @Query("SELECT * FROM currency_rate_table")
    fun getCurrencyRateList() : LiveData<List<CurrencyRate>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencyRate(item : CurrencyRate) : Long

    @Query("DELETE FROM currency_rate_table")
    fun deleteCurrencyRateTable()

    @Query("SELECT * FROM support_currency_table")
    fun getSupportCurrencyList() : LiveData<List<SupportCurrency>>

    @Query("SELECT code FROM support_currency_table")
    fun getSupportCurrencyAbbrList() : LiveData<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSupportCurrencyItem(item : SupportCurrency)

    @Query("DELETE FROM support_currency_table")
    fun deleteSupportCurrencyTable()


}