package com.amikomsd.recycraft.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.ActivityMainBinding
import com.amikomsd.recycraft.ui.fragment.HomeFragment
import com.amikomsd.recycraft.ui.fragment.MarketFragment
import com.amikomsd.recycraft.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, HomeFragment())
            commit()
        }
        binding.bottomNavigation.setOnItemSelectedListener setOnItemReselectedListener@{
            when(it.itemId){
                R.id.nav_home ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        HomeFragment()
                    ).commit()
                    return@setOnItemReselectedListener true
                } R.id.nav_shop ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragmentContainerView,
                    MarketFragment()
                ).commit()
                return@setOnItemReselectedListener true
            } R.id.nav_profile ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragmentContainerView,
                    ProfileFragment()
                ).commit()
                return@setOnItemReselectedListener true
            }
            }
            false
        }
    }
}