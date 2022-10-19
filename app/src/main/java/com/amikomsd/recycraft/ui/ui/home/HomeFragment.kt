package com.amikomsd.recycraft.ui.ui.home

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.FragmentHomeBinding
import com.amikomsd.recycraft.ui.maps.MapsActivity
import com.amikomsd.recycraft.ui.pick.PickActivity
import com.amikomsd.recycraft.ui.profile.ProfileActivity
import com.amikomsd.recycraft.ui.redeem.RedeemActivity


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStatusBar()

        binding.ivProfile.setOnClickListener {
            val toProfile = Intent(requireActivity(),ProfileActivity::class.java)
            startActivity(toProfile)
        }
        binding.lyTrashMarket.setOnClickListener {
            val toMaps = Intent(requireActivity(),MapsActivity::class.java)
            startActivity(toMaps)
        }
        binding.lyCraftLocation.setOnClickListener {
            val toPick = Intent(requireActivity(),PickActivity::class.java)
            startActivity(toPick)
        }
        binding.lyReddem.setOnClickListener {
            val toRedeem = Intent(requireActivity(),RedeemActivity::class.java)
            startActivity(toRedeem)
        }

    }

    private fun setupStatusBar() {
        activity?.window?.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = requireContext().resources.getColor(R.color.PremiereColor)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
        activity?.actionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}