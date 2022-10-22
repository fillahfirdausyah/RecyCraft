package com.amikomsd.recycraft.ui.addProduct

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.children
import com.amikomsd.recycraft.data.Product
import com.amikomsd.recycraft.databinding.ActivityAddProductBinding
import com.amikomsd.recycraft.utils.uriToFile
import com.google.android.material.chip.Chip
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import java.io.File

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding
    private var myFile: File? = null

    private val addProductViewModel by viewModels<AddProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.ivBack.setOnClickListener {
            finish()
        }


        binding.tvToGallery.setOnClickListener {
            startIntentToGallery()
        }

        binding.btnAddProduct.setOnClickListener {
            val productName = binding.edtProductName.text.toString()
            val productPrice = binding.edtProductPrice.text.toString()
            var madeOf = ""

            binding.chMadeOf.children.toList().filter {
                (it as Chip).isChecked
            }.map {
                madeOf = (it as Chip).text.toString()
            }

            when {
                myFile == null -> Toast.makeText(
                    this@AddProductActivity,
                    "Product photo is empty",
                    Toast.LENGTH_LONG
                ).show()
                binding.edtProductName.text.isEmpty() -> Toast.makeText(
                    this@AddProductActivity,
                    "Product name is empty",
                    Toast.LENGTH_LONG
                ).show()
                binding.edtProductPrice.text.isEmpty() -> Toast.makeText(
                    this@AddProductActivity,
                    "Product price is empty",
                    Toast.LENGTH_LONG
                ).show()
                madeOf == "" -> Toast.makeText(
                    this@AddProductActivity,
                    "Please select product type",
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    val product = Product(
                        myFile?.name!!, productName, productPrice.toInt(),
                        madeOf
                    )
                    addProductViewModel.addProduct(product, myFile!!, "Kerajinan Jogja")
                    addProductViewModel.isLoading.observe(this) { isLoading ->
                        showLoading(isLoading)
                    }
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.addProductLoadingScreen.root.visibility = View.VISIBLE
        } else {
            finish()
            binding.addProductLoadingScreen.root.visibility = View.GONE
        }
    }

    private fun startIntentToGallery() {
        val intent = Intent()
        intent.action = ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launchIntentGallery.launch(chooser)
    }

    private val launchIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            myFile = uriToFile(selectedImg, this@AddProductActivity)

            binding.ivProductPhotoPrteview.setImageURI(selectedImg)
        }
    }
}