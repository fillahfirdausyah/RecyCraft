package com.amikomsd.recycraft.adapters

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.data.Product
import com.amikomsd.recycraft.databinding.ItemProductMarketPlaceBinding
import com.amikomsd.recycraft.utils.setMargin
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class ListRecommendationMarketPlaceAdapter(private val listProductRecommendation: List<Product>) :
    RecyclerView.Adapter<ListRecommendationMarketPlaceAdapter.ViewHolder>() {

    private val storage = Firebase.storage


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductMarketPlaceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val storageRef = storage.reference
        val lastIndex = listProductRecommendation.size - 1
        val marginRightDP = 12f
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, marginRightDP,
            holder.itemView.context.resources.displayMetrics
        ).toInt()
        if (position == 0) {
            holder.binding.root.setMargin(left = 50, right = px)
        }

        if (position == lastIndex) {
            holder.binding.root.setMargin(left = px, right = 50)
        }

        storageRef.child("Product/Kerajinan Jogja/${listProductRecommendation[position].productImage}")
            .downloadUrl.addOnSuccessListener { uri ->
                Glide.with(holder.itemView.context).load(uri.toString())
                    .into(holder.binding.ivProduct)
            }
        holder.binding.tvProductName.text = listProductRecommendation[position].productName
        holder.binding.tvProductPrice.text =
            listProductRecommendation[position].productPrice.toString()
        holder.binding.tvProductValue.text =
            holder.itemView.context.resources.getString(R.string.product_value, "2.4", "68")
    }

    override fun getItemCount(): Int = listProductRecommendation.size

    inner class ViewHolder(val binding: ItemProductMarketPlaceBinding) :
        RecyclerView.ViewHolder(binding.root)
}