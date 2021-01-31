package com.example.a11acdhmwanimation_recycleview_cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a11acdhmwanimation_recycleview_cardview.databinding.RecycleviewItemBinding

class RecycleViewAdapter :
    RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>() {

    var list: List<Country> = listOf()
    var callback: ((View, View, View, Country) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecycleviewItemBinding.bind(itemView)
        init {
            itemView.setOnClickListener {
                callback?.invoke(
                    binding.ivFlag,
                    binding.tvTitle,
                    binding.tvCapital,
                    list[adapterPosition]
                )
            }
        }
        fun bind(country: Country) {
            binding.ivFlag.setImageResource(country.flag)
            binding.tvTitle.text = country.name
            binding.tvCapital.text = country.capital
        }
    }
}

