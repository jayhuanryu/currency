package com.jay.currency.repos

import android.content.Context
import com.jay.currency.Const

class SharedPreferenceStorage constructor(context: Context) : SharedPreferenceInterface {

    private val sharedPreference = context.getSharedPreferences(Const.APP_NAME, Context.MODE_PRIVATE)

    override fun setTimeStamp(key: String, value: Long) {
        with(sharedPreference.edit()) {
            putLong(key, value)
            apply()
        }
    }

    override fun getTimeStamp(key: String) : Long {
        return sharedPreference.getLong(key, 0L)
    }
}