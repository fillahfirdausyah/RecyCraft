package com.amikomsd.recycraft.adapters

import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amikomsd.recycraft.data.Redeem
import com.amikomsd.recycraft.databinding.ItemRedeemBinding
import com.amikomsd.recycraft.ui.redeem.RedeemDetilActivity

class RedeemAdapter(var listReedem: ArrayList<Redeem>) :
    RecyclerView.Adapter<RedeemAdapter.ViewHolder>() {

    var onClick: ((Redeem) -> Unit)? = null
    private lateinit var sharedPreferences: SharedPreferences


    class ViewHolder(var binding: ItemRedeemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRedeemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.imgItem.setImageResource(listReedem[position].image)
        holder.binding.TitleRedeem.text = listReedem[position].title
        holder.binding.descReedem.text = listReedem[position].desc
        holder.binding.CoinRedeem.text = listReedem[position].coin.toString()

        holder.binding.itemDetils.setOnClickListener {
            val intent = Intent(it.context, RedeemDetilActivity::class.java)
            intent.putExtra("image", listReedem[position].image)
            intent.putExtra("title", listReedem[position].title)
            intent.putExtra("desc", listReedem[position].desc)
            intent.putExtra("coin", listReedem[position].coin.toString())
            it.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return listReedem.size
    }

    fun setDataRedeem(ReedemList: ArrayList<Redeem>) {
        this.listReedem = ReedemList
    }
}