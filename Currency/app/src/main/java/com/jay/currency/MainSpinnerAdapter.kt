package com.jay.currency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jay.currency.data_model.SupportCurrency

class MainSpinnerAdapter(context : Context, val supportCurrencyList: List<SupportCurrency> ) : BaseAdapter() {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = supportCurrencyList.size

    override fun getItem(position: Int) = supportCurrencyList[position]


    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}