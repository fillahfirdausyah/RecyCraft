package com.amikomsd.recycraft.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amikomsd.recycraft.databinding.ActivityLoginBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.MainActivity

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeBottomNavigation::class.java)
            startActivity(intent)
        }

        binding.tvSignUp.setOnClickListener {
            val a = Intent(this, RegistActivity::class.java)
            startActivity(a)
        }
    }
}