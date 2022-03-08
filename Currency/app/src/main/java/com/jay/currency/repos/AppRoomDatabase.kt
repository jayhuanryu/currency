package com.jay.currency.repos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jay.currency.data_model.CurrencyRate
import com.jay.currency.data_model.SupportCurrency

@Database(entities = [CurrencyRate::class, SupportCurrency::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun mainDao() : MainDao

    companion object {
        @Volatile
        private var INSTANCE : AppRoomDatabase? = null

        fun getDatabase(context : Context) : AppRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "database").build()

                INSTANCE = instance
                return instance
            }
        }
    }

}