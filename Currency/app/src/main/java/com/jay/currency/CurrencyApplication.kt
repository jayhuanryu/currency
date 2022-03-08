package com.jay.currency

import android.app.Application
import com.jay.currency.repos.AppRoomDatabase
import com.jay.currency.repos.MainRepository
import com.jay.currency.repos.RemoteSourcesInterface
import com.jay.currency.repos.SharedPreferenceStorage

class CurrencyApplication : Application() {

    private val remoteInterface by lazy { RemoteSourcesInterface.create() }

    private val database by lazy { AppRoomDatabase.getDatabase(this) }
    private val sharedPreferenceStorage by lazy { SharedPreferenceStorage(this)}

    val repository by lazy { MainRepository(database.mainDao(), sharedPreferenceStorage, remoteInterface) }

}