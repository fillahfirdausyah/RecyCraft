package com.amikomsd.recycraft.ui.redeem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.adapters.RedeemAdapter
import com.amikomsd.recycraft.data.Redeem
import com.amikomsd.recycraft.databinding.ActivityRedeemBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.MainActivity

class RedeemActivity : AppCompatActivity() {

    lateinit var binding : ActivityRedeemBinding
    lateinit var rvReedem : RecyclerView
    lateinit var adapterRedeem : RedeemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRedeemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            val toHome = Intent(this, HomeBottomNavigation::class.java)
            startActivity(toHome)
        }

        val listRedeem = arrayListOf(
            Redeem(R.drawable.ic_picture_empty,"Sancken","Minyak goreng sehat sanken dan ramah lingkungan",20),
            Redeem(R.drawable.ic_picture_empty,"Beras Rojo Lele 25 KG","Beras rojo lele asli jawa timur",100),
            Redeem(R.drawable.ic_picture_empty,"Mie Instant","Indomie Goreng Satu dus",40),
        )

        binding.rvReedem.adapter = RedeemAdapter(listRedeem)
        binding.rvReedem.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

   }
}