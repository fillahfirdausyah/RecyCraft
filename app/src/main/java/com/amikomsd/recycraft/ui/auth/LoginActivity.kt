package com.amikomsd.recycraft.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amikomsd.recycraft.databinding.ActivityLoginBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        auth = Firebase.auth

        formValidation()

        binding.btnLogin.setOnClickListener {
            binding.loginLoadingScreen.root.visibility = View.VISIBLE
            loginAction()
        }

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
    }

    private fun formValidation() {
        when {
            binding.etEmail.text?.isEmpty()!! -> binding.btnLogin.isClickable = false
            binding.etPassword.text?.isEmpty()!! -> binding.btnLogin.isClickable = false
            else -> binding.btnLogin.isClickable = true
        }
    }

    private fun loginAction() {
        // Acomodate all user credential
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.toString()
        /**
         * Login action to Firebase Auth
         * @param email is val user email
         * @param password is password user
         */
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                binding.loginLoadingScreen.root.visibility = View.GONE
                val intent = Intent(this@LoginActivity, HomeBottomNavigation::class.java)
                startActivity(intent)
            } else {
                binding.loginLoadingScreen.root.visibility = View.GONE
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}