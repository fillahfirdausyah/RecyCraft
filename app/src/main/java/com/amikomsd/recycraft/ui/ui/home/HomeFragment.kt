package com.amikomsd.recycraft.ui.ui.home

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
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

<<<<<<< Updated upstream
        binding.ivProfile.setOnClickListener {
            val toProfile = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(toProfile)
        }
        binding.lyRedeem.setOnClickListener {
            val toRedeem = Intent(requireActivity(),RedeemActivity::class.java)
            startActivity(toRedeem)
        }
        binding.lyLocation.setOnClickListener {
            val toMap = Intent(requireActivity(),PickActivity::class.java)
            startActivity(toMap)
        }
        binding.lyTrashMarket.setOnClickListener {
            val toMarket = Intent(requireActivity(),MapsActivity::class.java)
            startActivity(toMarket)

        }
=======
        binding.lyReedem.setOnClickListener {
            val toRedeem = Intent(context,RedeemActivity::class.java)
            startActivity(toRedeem)
        }

        binding.lyTrashMarket.setOnClickListener {
            val toPick = Intent(requireActivity(),PickActivity::class.java)
            startActivity(toPick)
        }

        binding.lyCraftLocation.setOnClickListener {
            val toMap = Intent(requireActivity(),MapsActivity::class.java)
            startActivity(toMap)
        }


        binding.ivProfile.setOnClickListener {
            val toProfile = Intent(requireActivity(),ProfileActivity::class.java)
            startActivity(toProfile)
        }

>>>>>>> Stashed changes
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