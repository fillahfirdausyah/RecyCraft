package com.amikomsd.recycraft.ui.redeem

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amikomsd.recycraft.databinding.ActivityRedeemDetilBinding

class RedeemDetilActivity : AppCompatActivity() {

    lateinit var binding: ActivityRedeemDetilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRedeemDetilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        getIntentExtra()

        binding.ivBack.setOnClickListener {
            val toRedeem = Intent(this, RedeemActivity::class.java)
            startActivity(toRedeem)
        }

    }

    fun getIntentExtra() {
        val myData = intent
        val gambar = myData.getIntExtra("image", 0)
        val title = myData.getStringExtra("title")
        val desc = myData.getStringExtra("desc")
        val coin = myData.getStringExtra("coin")

        binding.ivDetil.setImageResource(gambar)
        binding.tvTitleDetil.text = title
        binding.tvDescDetil.text = desc
        binding.tvCoinDetil.text = coin
    }
}