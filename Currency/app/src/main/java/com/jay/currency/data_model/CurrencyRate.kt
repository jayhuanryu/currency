package com.jay.currency.data_model

import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_rate_table")
class CurrencyRate(
    @PrimaryKey
    val code: String,
    val rate: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeDouble(rate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurrencyRate> {
        override fun createFromParcel(parcel: Parcel): CurrencyRate {
            return CurrencyRate(parcel)
        }

        override fun newArray(size: Int): Array<CurrencyRate?> {
            return arrayOfNulls(size)
        }

        @JvmStatic
        @BindingAdapter("app:setRateText")
        fun setRateText(textView : TextView, rate : Double) {
            textView.text = rate.toString()
        }

        @JvmStatic
        @BindingAdapter("app:setCodeText")
        fun setCodeText(textView : TextView, code : String) {
            textView.text = code
        }
    }
}