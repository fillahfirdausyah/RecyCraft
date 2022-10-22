package com.amikomsd.recycraft.ui.marketPlace

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.adapters.ListRecommendationMarketPlaceAdapter
import com.amikomsd.recycraft.data.Product
import com.amikomsd.recycraft.databinding.ActivityMarketPlaceBinding

class MarketPlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivityMarketPlaceBinding

    private val marketPlaceViewModel by viewModels<MarketPlaceViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView(R.layout.custom_view_market_place_action_bar)

        marketPlaceViewModel.getAllProduct()
        marketPlaceViewModel.listAllProduct.observe(this) { listAllProduct ->
            setupAdapter(listAllProduct)
        }
    }

    private fun setupAdapter(listAllProduct: List<Product>) {
        binding.rvMarketPlaceProductRecommendation.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMarketPlaceProductRecommendation.adapter =
            ListRecommendationMarketPlaceAdapter(listAllProduct)
    }
}