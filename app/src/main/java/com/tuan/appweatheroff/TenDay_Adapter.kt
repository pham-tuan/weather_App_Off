package com.tuan.appweatheroff

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tuan.appweatheroff.databinding.ItemTenDayBinding

class TenDay_Adapter(private val list: List<Ten_Day>) :
    RecyclerView.Adapter<TenDay_Adapter.TenDayViewHolder>(){


    inner class TenDayViewHolder(val binding: ItemTenDayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(Ten_Day: Ten_Day) {
            binding.img.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.img.context,
                    Ten_Day.img
                )
            )
            binding.temp.text = Ten_Day.temp
            binding.day.text = Ten_Day.day

        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenDayViewHolder {
        return TenDayViewHolder(
            ItemTenDayBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TenDayViewHolder, position: Int) {
        holder.bind(list[position])
    }

}