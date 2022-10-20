package com.amikomsd.recycraft.ui.marketPlace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.ActivityMarketPlaceBinding

class MarketPlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivityMarketPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView(R.layout.custom_view_market_place_action_bar)


    }
}