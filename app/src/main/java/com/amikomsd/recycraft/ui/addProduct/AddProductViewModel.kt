package com.amikomsd.recycraft.ui.addProduct

import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amikomsd.recycraft.data.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.File

class AddProductViewModel : ViewModel() {
    private val storage = Firebase.storage
    private val firestore = Firebase.firestore

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun addProduct(product: Product, productImageFile: File, storeName: String) {
        _isLoading.value = true
        val storageRef = storage.reference
        val prodductImageRef = storageRef
            .child("Product/${storeName}/${productImageFile.name}")
        val uploadImageTask = prodductImageRef.putFile(productImageFile.toUri())

        uploadImageTask.addOnSuccessListener { task ->
            Log.d("UPLOADED", "uploaded")
            firestore.collection("Product $storeName")
                .document().set(product).addOnCompleteListener { taskFirestore ->
                    if (taskFirestore.isSuccessful) {
                        _isLoading.value = false
                    }
                }
        }.addOnFailureListener { task ->
            _isLoading.value = false
            Log.d("FAILURE", task.message.toString())
        }
    }
}