package com.tuan.appweatheroff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.tuan.appweatheroff.databinding.FragmentMainBinding
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        setbottom()
        handlerViewPager()
        setOnClick()
        return binding.root
    }

    private fun setOnClick() {
        binding.llView.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_listFragment)
        }
    }

    private fun handlerViewPager() {
        val madapter = activity?.let { ViewPagerAdapter(it.supportFragmentManager, lifecycle) }

        binding.pager.adapter = madapter
        TabLayoutMediator(binding.tab, binding.pager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Hourly Forecast"
                }

                1 -> {
                    tab.text = "Dayly Forecast"
                }

            }
        }.attach()
    }

    private fun setbottom() {
        val sheetBehavior = BottomSheetBehavior.from(binding.sheet)
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }


}
