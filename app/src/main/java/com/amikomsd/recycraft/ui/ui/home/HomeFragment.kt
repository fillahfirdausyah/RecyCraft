package com.amikomsd.recycraft.ui.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.FragmentHomeBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.MainActivity


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

        (activity as HomeBottomNavigation?)!!.supportActionBar!!.title = "hello word"
        (activity as HomeBottomNavigation?)!!.supportActionBar!!.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as HomeBottomNavigation?)!!.supportActionBar!!.setDisplayShowCustomEnabled(true)
        (activity as HomeBottomNavigation?)!!.supportActionBar!!.setCustomView(R.layout.action_bar_search)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupMenu()

        val cobaSearch = requireActivity().findViewById<EditText>(R.id.cobaSearch)

        cobaSearch.addTextChangedListener {
            Log.d("APA", it.toString())
        }

    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.option_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.userProfile -> Toast.makeText(
                        requireContext(),
                        "Hello Madepaker",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return true
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}