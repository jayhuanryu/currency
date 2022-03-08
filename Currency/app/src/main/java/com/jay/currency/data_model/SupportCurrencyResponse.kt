package com.jay.currency.data_model



class SupportCurrencyResponse (
    val success : Boolean,
    val terms : String,
    val privacy : String,
    val currencies : Map<String, String>
    )