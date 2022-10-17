package com.amikomsd.recycraft.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.FragmentTambahBinding

class TambahFragment : Fragment() {

    lateinit var binding : FragmentTambahBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}