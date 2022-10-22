package com.amikomsd.recycraft.ui.marketPlace

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amikomsd.recycraft.data.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MarketPlaceViewModel : ViewModel() {

    private val firestore = Firebase.firestore

    val listAllProduct: MutableLiveData<List<Product>> = MutableLiveData()

    fun getAllProduct() {
        firestore.collection("Product Kerajinan Jogja")
            .addSnapshotListener { snapshoot, error ->
                val _listAllProduct: MutableList<Product> = mutableListOf()
                for (document in snapshoot!!) {
                    _listAllProduct.add(document.toObject(Product::class.java))
                }
                listAllProduct.value = _listAllProduct
            }
    }

}