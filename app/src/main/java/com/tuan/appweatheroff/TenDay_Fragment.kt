package com.tuan.appweatheroff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuan.appweatheroff.databinding.FragmentTenDayBinding

class TenDay_Fragment : Fragment() {
    lateinit var binding: FragmentTenDayBinding
    private var listDay: List<Ten_Day>? = null
    private var dayAdapter: TenDay_Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTenDayBinding.inflate(layoutInflater)
        handleTempDay()
        return binding.root
    }

    private fun handleTempDay() {
        listDay = listOf(
            Ten_Day("Now", R.drawable.sunny, "32°/24°"),
            Ten_Day("Wednesday", R.drawable.cloudy, "30°/23°"),
            Ten_Day("Thursday", R.drawable.rainy, "27°/23°"),
            Ten_Day("Friday", R.drawable.storm, "26°/21°"),
            Ten_Day("Saturday", R.drawable.snowy, "3°/-2°"),
            Ten_Day("Sunday", R.drawable.wind, "24°/21°"),
            Ten_Day("Monday", R.drawable.windy, "25°/21°"),
            Ten_Day("Tuesday", R.drawable.snowy, "2°/-2°"),
            Ten_Day("Wednesday ", R.drawable.snowy, "4°/0°"),
            Ten_Day("Thursday", R.drawable.cloudy, "15°/9°"),
        )

        binding.rcTenday.apply {
            val layoutParams =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            layoutManager = layoutParams
            dayAdapter = TenDay_Adapter(listDay ?: listOf())
            adapter = dayAdapter

        }

    }


}