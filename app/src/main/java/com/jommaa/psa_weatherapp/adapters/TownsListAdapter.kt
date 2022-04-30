package com.jommaa.psa_weatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.adapters.TownsListAdapter.Holder
import com.jommaa.psa_weatherapp.databinding.ListItemTownBinding

class TownsListAdapter (restaurants: ObservableList<Town>) :
    ObservableRecyclerViewAdapter<Town, Holder>(restaurants) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ListItemTownBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Holder(
        private val binding: ListItemTownBinding,
        private val onItemClickListener: ((item: Any) -> Unit)?) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var townResponse: Town

        fun bind(townResponse: Town) {
            this.townResponse = townResponse

            binding.name.text = townResponse.name

            binding.root.setOnClickListener { onItemClickListener?.invoke(townResponse) }
        }
    }
}
