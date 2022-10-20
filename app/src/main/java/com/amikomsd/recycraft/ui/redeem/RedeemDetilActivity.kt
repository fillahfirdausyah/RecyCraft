package com.amikomsd.recycraft.ui.redeem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amikomsd.recycraft.data.Redeem
import com.amikomsd.recycraft.databinding.ActivityRedeemDetilBinding
import com.bumptech.glide.Glide

class RedeemDetilActivity : AppCompatActivity() {

    lateinit var binding : ActivityRedeemDetilBinding
    var angka = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRedeemDetilBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        getBundle()

        binding.ivBack.setOnClickListener {
            val toRedeem = Intent(this,RedeemActivity::class.java)
            startActivity(toRedeem)
        }

        binding.ivIncrement.setOnClickListener {
            increment()
        }
        binding.ivDecrement.setOnClickListener {
            decrement()
        }

    }

    fun increment(){
        angka++
        var strAngka = angka.toString()
        binding.tvResult.text = strAngka
    }

    fun decrement(){
        if (angka>0){
            angka--
            var strAngka = angka.toString()
            binding.tvResult.text = strAngka
        }else{
            Toast.makeText(this, "Can't Negative", Toast.LENGTH_SHORT).show()
        }
    }
//    fun getBundle(){
//        val myData = intent
//        val gambar = myData.getStringExtra("image")
//        val title = myData.getStringExtra("title")
//        val desc = myData.getStringExtra("desc")
//        val coin = myData.getStringExtra("coin")
//
//        Glide.with(this).load("image $gambar").into(binding.ivDetil)
//        binding.tvTitleDetil.text = title
//        binding.tvDescDetil.text = desc
//        binding.tvCoinDetil.text = coin
//    }
}