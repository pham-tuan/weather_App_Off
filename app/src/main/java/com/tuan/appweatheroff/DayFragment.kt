package com.tuan.appweatheroff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuan.appweatheroff.databinding.FragmentDayBinding

class DayFragment : Fragment() {

    lateinit var binding : FragmentDayBinding
    private var listhour: List<Hourly_Forecast>? = null
    private var hourAdapter: Hourly_Forecast_Adapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayBinding.inflate(layoutInflater)
        handleTempDayNow()
        return binding.root
    }

    private fun handleTempDayNow() {
        listhour = listOf(
            Hourly_Forecast("25°",R.drawable.sunny, "Now"),
            Hourly_Forecast("25°",R.drawable.cloudy, "12PM"),
            Hourly_Forecast("26°",R.drawable.rainy, "14PM"),
            Hourly_Forecast("27°",R.drawable.storm, "16PM"),
            Hourly_Forecast("26°",R.drawable.snowy, "18PM"),
            Hourly_Forecast("25°",R.drawable.wind, "20PM"),
            Hourly_Forecast("23°",R.drawable.windy, "22PM"),
            Hourly_Forecast("22°",R.drawable.snowy, "24PM"),
        )

        binding.rcHourly.apply {
            val layoutParams =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            layoutManager = layoutParams
            hourAdapter = Hourly_Forecast_Adapter(listhour ?: listOf())
            adapter = hourAdapter

        }
    }
}