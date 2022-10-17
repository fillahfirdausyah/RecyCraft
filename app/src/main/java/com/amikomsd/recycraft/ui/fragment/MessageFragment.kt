package com.amikomsd.recycraft.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {

    lateinit var binding : FragmentMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessageBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}