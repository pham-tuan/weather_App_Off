package com.tuan.appweatheroff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuan.appweatheroff.databinding.FragmentListBinding
import androidx.core.widget.doOnTextChanged

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private var list: List<ListCity>? = null
    private var listAdapter: ListCityAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        handleList()
        return binding.root
    }

    private fun handleList() {
        list = listOf(
            ListCity("20°",R.drawable.m1, "ToKyo , Japan ", "rain "),
            ListCity("25°",R.drawable.m2, "Sydney , Australia ", "rain "),
            ListCity("12°",R.drawable.m5, "Toronto , Canada ", "rain "),
            ListCity("29°",R.drawable.m3, "La Habana , Cuba ", "rain "),
            ListCity("22°",R.drawable.m1, "Paris , Pháp ", "rain "),
            ListCity("16°",R.drawable.m4, "Berlin , Đức", "rain "),
            ListCity("30°",R.drawable.m4, "Seoul , Hàn Quốc ", "rain "),
            ListCity("25°",R.drawable.m2, "Moskva , Nga ", "rain "),

            )

        binding.rcList.apply {
            var layoutParams =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            layoutManager = layoutParams
            listAdapter = ListCityAdapter()
            listAdapter?.setupData(list ?: listOf())
            adapter = listAdapter


            binding.edtseach.doOnTextChanged { text, start, before, count ->
                listAdapter?.filter?.filter(text.toString())
            }

        }

    }


}