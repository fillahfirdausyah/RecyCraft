package com.amikomsd.recycraft.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.amikomsd.recycraft.databinding.ActivitySplashBinding
import com.amikomsd.recycraft.ui.auth.LoginActivity

class SplashActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        Handler(Looper.myLooper()!!).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        },3000)
        setContentView(binding.root)
    }
}