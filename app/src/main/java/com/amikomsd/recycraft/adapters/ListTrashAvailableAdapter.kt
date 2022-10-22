package com.amikomsd.recycraft.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amikomsd.recycraft.data.TrashAvailable
import com.amikomsd.recycraft.databinding.ItemTrashAvailableBinding
import com.amikomsd.recycraft.utils.setMargin

class ListTrashAvailableAdapter(private val listTrashAvailable: List<TrashAvailable>) :
    RecyclerView.Adapter<ListTrashAvailableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTrashAvailableBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lastIndex = listTrashAvailable.size - 1
        if (position == 0) {
            holder.binding.root.setMargin(left = 50, right = 25)
        } else if (position == lastIndex) {
            holder.binding.root.setMargin(left = 25, right = 50)
        } else {
            holder.binding.root.setMargin(left = 8, right = 8)
        }

        holder.binding.ivTrashAvailable.setImageResource(listTrashAvailable[position].image)
        holder.binding.tvTitleTrashAvailable.text = listTrashAvailable[position].name
        holder.binding.tvPriceTrashAvailable.text = listTrashAvailable[position].price
        holder.binding.tvQtyTrashAvailable.text = listTrashAvailable[position].qty
        holder.binding.tvWhoHasTrashAvailable.text = listTrashAvailable[position].whoHas
    }

    override fun getItemCount(): Int = listTrashAvailable.size

    inner class ViewHolder(val binding: ItemTrashAvailableBinding) :
        RecyclerView.ViewHolder(binding.root)
}