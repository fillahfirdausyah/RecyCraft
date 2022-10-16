package com.amikomsd.recycraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amikomsd.recycraft.databinding.ActivityRegistBinding

class RegistActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegist.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.tvLogin.setOnClickListener {
            val a = Intent(this,LoginActivity::class.java)
            startActivity(a)
        }
    }
}