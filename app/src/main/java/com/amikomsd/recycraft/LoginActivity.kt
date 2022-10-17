package com.amikomsd.recycraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amikomsd.recycraft.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    
    lateinit var binding : ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvSignUp.setOnClickListener {
            val a = Intent(this,RegistActivity::class.java)
            startActivity(a)
        }
    }
}