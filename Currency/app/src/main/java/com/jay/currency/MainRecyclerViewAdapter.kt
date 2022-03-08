package com.jay.currency

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.currency.data_model.CurrencyRate
import com.jay.currency.databinding.ItemRvCalucatedAmountBinding


class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = listOf<CurrencyRate>()

    fun updateList(list : List<CurrencyRate>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding : ItemRvCalucatedAmountBinding = ItemRvCalucatedAmountBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ViewHolder).bind(list[position])

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding : ItemRvCalucatedAmountBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CurrencyRate) {
            binding.data = item
        }
    }
}