package com.example.googlemapbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val position = LatLng(31.517992, 74.370773)
    var markerOptions = MarkerOptions().position(position)
    lateinit var marker : Marker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(mapView) {
            // Initialise the MapView
            onCreate(null)
            // Set the map ready callback to receive the GoogleMap object
            getMapAsync{
                com.google.android.gms.maps.MapsInitializer.initialize(applicationContext)
                setMapLocation(it)
            }
        }
    }
    private fun setMapLocation(map : GoogleMap) {
        with(map) {
            moveCamera(CameraUpdateFactory.newLatLngZoom(position, 13f))
            mapType = GoogleMap.MAP_TYPE_NORMAL
            addMarker(markerOptions) //default marker set
            setOnMapClickListener {
                if(::marker.isInitialized){
                    marker.remove()
                }
                markerOptions.position(it)
                marker = addMarker(markerOptions)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
