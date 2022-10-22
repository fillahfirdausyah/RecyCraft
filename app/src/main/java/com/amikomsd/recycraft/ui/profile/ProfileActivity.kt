package com.amikomsd.recycraft.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.ActivityProfileBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.auth.LoginActivity

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.tvUserName.text = intent.getStringExtra("nama")

        binding.btnLogout.setOnClickListener {
            alertDialog()
        }

        binding.ivBack.setOnClickListener {
            val intent = Intent(this,HomeBottomNavigation::class.java)
            startActivity(intent)
        }
    }
    fun alertDialog(){
        val builder = AlertDialog.Builder(this)


        builder.setTitle(R.string.title)
        builder.setMessage(R.string.dialogMsg)

        builder.setNegativeButton("No"){dialogInterface, which ->

        }
        builder.setPositiveButton("Yes"){dialogInterface, which->
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Logout", Toast.LENGTH_LONG).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
}