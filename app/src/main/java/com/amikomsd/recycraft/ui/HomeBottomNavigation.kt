package com.amikomsd.recycraft.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.ActivityHomeBottomNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeBottomNavigation : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val navView: BottomNavigationView = binding.navView

        val navController =
            findNavController(R.id.nav_host_fragment_activity_home_bottom_navigation)
        navView.setupWithNavController(navController)
    }
}