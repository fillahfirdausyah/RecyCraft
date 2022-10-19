package com.amikomsd.recycraft.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amikomsd.recycraft.data.ProductRecomendation
import com.amikomsd.recycraft.databinding.ItemProductRecomendationBinding
import com.amikomsd.recycraft.utils.setMargin

class ListProductRecomendationAdapter(private val listProductRecomendation: List<ProductRecomendation>) :
    RecyclerView.Adapter<ListProductRecomendationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductRecomendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lastIndex = listProductRecomendation.size - 1
        if (position == 0) {
            holder.binding.root.setMargin(left = 50, right = 25)
        }

        if (position == lastIndex) {
            holder.binding.root.setMargin(left = 25, right = 50)
        }
        holder.binding.ivProductRecomendation.setImageResource(listProductRecomendation[position].image)
        holder.binding.tvTitleProductRecomendation.text = listProductRecomendation[position].name
        holder.binding.tvPriceProductRecomendation.text = listProductRecomendation[position].price
    }

    override fun getItemCount(): Int = listProductRecomendation.size

    inner class ViewHolder(val binding: ItemProductRecomendationBinding) :
        RecyclerView.ViewHolder(binding.root)
}