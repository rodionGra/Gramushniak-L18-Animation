package com.example.a11acdhmwanimation_recycleview_cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a11acdhmwanimation_recycleview_cardview.databinding.RecycleviewItemCountryInfoBinding

class RecycleViewAdapter(private val list: List<Country>) : RecyclerView.Adapter<MyViewHolder>() {
    var callback: ((View, View, View, Country) -> Unit) = { _, _, _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleview_item_country_info, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position], callback)
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = RecycleviewItemCountryInfoBinding.bind(itemView)

    fun bind(country: Country, callback: ((View, View, View, Country) -> Unit)) {
        binding.apply {
            ivFlag.setImageResource(country.flag)
            tvTitle.text = country.name
            tvCapital.text = country.capital
        }

        itemView.setOnClickListener {
            callback(binding.ivFlag, binding.tvTitle, binding.tvCapital, country)
        }
    }
}

