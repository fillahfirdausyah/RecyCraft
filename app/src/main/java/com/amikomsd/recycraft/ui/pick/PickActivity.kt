package com.amikomsd.recycraft.ui.pick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.amikomsd.recycraft.R
import com.amikomsd.recycraft.databinding.ActivityPickBinding
import com.amikomsd.recycraft.ui.HomeBottomNavigation
import com.amikomsd.recycraft.ui.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PickActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var binding : ActivityPickBinding
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView(R.layout.custom_view_maps_action_bar)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

//        binding.ivBack.setOnClickListener {
//            val toHome = Intent(this, HomeBottomNavigation::class.java)
//            startActivity(toHome)
//        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng( -7.797068, 110.370529)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Yogyakarta"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}