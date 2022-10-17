package com.amikomsd.recycraft.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.amikomsd.recycraft.databinding.ActivityRegistBinding
import com.amikomsd.recycraft.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        firestore = Firebase.firestore

        formValidation()

        binding.btnRegist.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
            registerAction()
        }
        binding.tvLogin.setOnClickListener {
            val a = Intent(this, LoginActivity::class.java)
            startActivity(a)
        }
    }

    private fun formValidation() {
        binding.etConfirmPassword.addTextChangedListener { confirmPassword ->
            if (confirmPassword.toString() != binding.etPassword.text.toString()) {
                binding.btnRegist.isClickable = false
                binding.confirmPasswordTextInputLayout.isEndIconVisible = false
                binding.etConfirmPassword.error = "Confirm password is not match"
            } else {
                binding.btnRegist.isClickable = true
                binding.confirmPasswordTextInputLayout.isEndIconVisible = true
            }
        }

        binding.etPassword.addTextChangedListener { password ->
            if (password!!.length < 6) {
                binding.etPassword.error = "Password must min 6 character"
                binding.passwordTextInputLayout.isEndIconVisible = false
            } else {
                binding.passwordTextInputLayout.isEndIconVisible = true
            }
        }
    }

    private fun registerAction() {
        // accomodate all user credential
        val fullName = binding.etFullName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()


//        val user = User(fullName, email)

        /**
         * Create user action using Firebase Auth
         * @param email is val user email
         * @param password is password user
         */
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val currentUser = auth.currentUser
                val profile = userProfileChangeRequest {
                    displayName = fullName
                }
                currentUser!!.updateProfile(profile)
                updateUI(currentUser)
            }
        }

    }

    /**
     * Update UI when user registered
     * @param currentUser current user instance from create user action
     */
    private fun updateUI(currentUser: FirebaseUser) {
        if (currentUser != null) {
            val intent = Intent(this@RegistActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}