package com.jay.currency.data_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "support_currency_table")
class SupportCurrency(
    @PrimaryKey
    val code: String,
    val currency: String
)