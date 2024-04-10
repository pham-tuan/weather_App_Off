package com.tuan.appweatheroff

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tuan.appweatheroff.databinding.ItemHourlyForecastBinding

class Hourly_Forecast_Adapter (private val list: List<Hourly_Forecast>) :
    RecyclerView.Adapter<Hourly_Forecast_Adapter.HourFViewHolder>(){


    inner class HourFViewHolder(val binding: ItemHourlyForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(Hour_F: Hourly_Forecast) {
            binding.image.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.image.context,
                    Hour_F.img
                )
            )
            binding.temp.text = Hour_F.temp
            binding.hour.text = Hour_F.hour

        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourFViewHolder {
        return HourFViewHolder(
            ItemHourlyForecastBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HourFViewHolder, position: Int) {
        holder.bind(list[position])
    }

}