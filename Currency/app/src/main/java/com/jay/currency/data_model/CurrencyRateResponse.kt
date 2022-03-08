package com.jay.currency.data_model

import org.json.JSONObject

class CurrencyRateResponse (
    val success : Boolean,
    val terms : String,
    val privacy : String,
    val timestamp: Long,
    val source : String,
    val quotes : Map<String, Double>
    )