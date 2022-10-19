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
import androidx.recyclerview.widget.LinearLayoutManager
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.adapters.ListProductRecomendationAdapter
import com.amikomsd.recycraft.adapters.ListTrashAvailableAdapter
import com.amikomsd.recycraft.data.ProductRecomendation
import com.amikomsd.recycraft.data.TrashAvailable
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

        binding.ivToProfile.setOnClickListener {
            val toProfile = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(toProfile)
        }
        binding.lyTrashMarket.setOnClickListener {
            val toMaps = Intent(requireActivity(), MapsActivity::class.java)
            startActivity(toMaps)
        }
        binding.lyCraftLocation.setOnClickListener {
            val toPick = Intent(requireActivity(), PickActivity::class.java)
            startActivity(toPick)
        }
        binding.lyReddem.setOnClickListener {
            val toRedeem = Intent(requireActivity(), RedeemActivity::class.java)
            startActivity(toRedeem)
        }



        mockDataProductRecomendation()
        mockDataTrashAvailable()

    }

    private fun mockDataTrashAvailable() {
        val listTrashAvailable = arrayListOf<TrashAvailable>(
            TrashAvailable(
                R.drawable.sampah_plastik,
                "Botol Plastik",
                "Rp20.000", "2 Kresek",
                "Barry Allen"
            ),
            TrashAvailable(
                R.drawable.sampah_plastik,
                "Botol Kaca",
                "Rp25.000", "1 Dus",
                "Harison Wels"
            ),
            TrashAvailable(
                R.drawable.sampah_plastik,
                "Kardus",
                "Rp10.000", "5 Kardus",
                "Cisco Ramon"
            ),
            TrashAvailable(
                R.drawable.sampah_plastik,
                "Baju Bekas",
                "Rp40.000", "2 Kantong",
                "Iris West"
            ),
            TrashAvailable(
                R.drawable.sampah_plastik,
                "Dus Mie Instan",
                "Rp10.000", "5 Dus",
                "Caitlin Snow"
            ),
        )

        binding.rvListTrashAvailable.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvListTrashAvailable.adapter = ListTrashAvailableAdapter(listTrashAvailable)
    }

    private fun mockDataProductRecomendation() {
        val listProductRecomendation = arrayListOf<ProductRecomendation>(
            ProductRecomendation(R.drawable.product1, "Product 1", "Rp19.000"),
            ProductRecomendation(R.drawable.product1, "Product 2", "Rp16.000"),
            ProductRecomendation(R.drawable.product1, "Product 3", "Rp11.000"),
        )

        binding.rvListProductRecomendation.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvListProductRecomendation.adapter =
            ListProductRecomendationAdapter(listProductRecomendation)
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