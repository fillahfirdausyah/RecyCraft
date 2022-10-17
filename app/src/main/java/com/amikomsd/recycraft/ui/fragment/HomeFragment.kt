package com.amikomsd.recycraft.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amikomsd.recycraft.ui.auth.LoginActivity
import com.amikomsd.recycraft.databinding.FragmentHomeBinding
import com.amikomsd.recycraft.ui.maps.MapsActivity
import com.amikomsd.recycraft.ui.pick.PickActivity
import com.amikomsd.recycraft.ui.profile.ProfileActivity


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivProfile.setOnClickListener {
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.lyMaps.setOnClickListener {
            val toMaps = Intent(context, MapsActivity::class.java)
            startActivity(toMaps)
        }
        binding.lyPickTrash.setOnClickListener {
            val toPick = Intent(context,PickActivity::class.java)
            startActivity(toPick)
        }
    }

}