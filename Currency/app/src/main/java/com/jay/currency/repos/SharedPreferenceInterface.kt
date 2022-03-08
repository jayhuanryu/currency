package com.jay.currency.repos

interface SharedPreferenceInterface {

    fun setTimeStamp(key: String, value: Long)
    fun getTimeStamp(key: String) : Long
}