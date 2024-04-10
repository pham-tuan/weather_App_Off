package com.tuan.appweatheroff

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tuan.appweatheroff.databinding.ItemListcityBinding

class ListCityAdapter : RecyclerView.Adapter<ListCityAdapter.ListCityViewHolder>(), Filterable {

    private val listCity = ArrayList<ListCity>()
    private var listCityFiltered = ArrayList<ListCity>()
    var onClickItem: ((ListCity) -> Unit)? = null

    inner class ListCityViewHolder(val binding: ItemListcityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ListCity: ListCity) {
            binding.img. setImageDrawable (
                ContextCompat.getDrawable(
                    binding.img.context,
                    ListCity.img
                )
            )
            binding.name.text = ListCity.name
            binding.temp.text = ListCity.temp
            binding.desc.text = ListCity.desc

            binding.root.setOnClickListener {
                onClickItem?.invoke(ListCity)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCityViewHolder {
        return ListCityViewHolder(
            ItemListcityBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listCityFiltered.size
    }

    override fun onBindViewHolder(holder: ListCityViewHolder, position: Int) {
        holder.bind(listCityFiltered[position])
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                listCityFiltered = if (charString.isEmpty()) {
                    listCity
                } else {
                    val filterList = ArrayList<ListCity>()
                    for (city in listCity) {
                        if ((city.name).lowercase().contains((charString.lowercase()))) {
                            filterList.add(city)
                        }
                    }
                    filterList
                }
                val filterResult = FilterResults()
                filterResult.values = listCityFiltered
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listCityFiltered = results?.values as ArrayList<ListCity>
                notifyDataSetChanged()
            }
        }
    }

    fun setupData(newData: List<ListCity>) {
        listCity.clear().also {
            listCity.addAll(newData)
            filter.filter("")
        }
    }


}