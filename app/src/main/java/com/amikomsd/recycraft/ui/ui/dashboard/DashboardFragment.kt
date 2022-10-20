package com.amikomsd.recycraft.ui.ui.dashboard

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.amikomsd.recycraft.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupStatusBar()
    }

//    private fun setupStatusBar() {
//        activity?.window?.apply {
//            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            statusBarColor = Color.TRANSPARENT
//            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//        activity?.actionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}