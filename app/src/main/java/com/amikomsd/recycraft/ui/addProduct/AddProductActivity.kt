package com.amikomsd.recycraft.ui.addProduct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amikomsd.recycraft.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}