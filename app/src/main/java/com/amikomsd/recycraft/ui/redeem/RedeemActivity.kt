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
import com.amikomsd.recycraft.databinding.ItemRedeemBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.MainActivity

class RedeemActivity : AppCompatActivity() {

    lateinit var binding: ActivityRedeemBinding
    private lateinit var redeemAdapter: RedeemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRedeemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.ivBack.setOnClickListener {
            val toHome = Intent(this, HomeBottomNavigation::class.java)
            startActivity(toHome)
        }

        val listRedeem = arrayListOf(
            Redeem(
                R.drawable.dummy_bimoli,
                "Bimoli",
                "Minyak goreng sehat sanken dan ramah lingkungan",
                20
            ),
            Redeem(
                R.drawable.dummy_beras,
                "Beras Rojo Lele 25 KG",
                "Beras rojo lele asli jawa timur",
                20
            ),
            Redeem(R.drawable.dummy_mie,
                "Mie Instant",
                "Indomie Goreng Satu dus",
                20),
        )


        binding.rvReedem.adapter = RedeemAdapter(listRedeem)
        binding.rvReedem.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}