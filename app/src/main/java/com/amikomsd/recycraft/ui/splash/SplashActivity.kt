package com.amikomsd.recycraft.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.amikomsd.recycraft.databinding.ActivitySplashBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        auth = Firebase.auth

        val currentUser = auth.currentUser



        Handler(Looper.myLooper()!!).postDelayed({
            if (currentUser != null) {
                val intent = Intent(this@SplashActivity, HomeBottomNavigation::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }, 3000)
        setContentView(binding.root)
    }
}