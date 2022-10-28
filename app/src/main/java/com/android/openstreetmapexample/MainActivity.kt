package com.android.openstreetmapexample

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.android.openstreetmapexample.databinding.ActivityMainBinding
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.config.Configuration.*


class MainActivity : AppCompatActivity() {
    private var mMapController: MapController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        binding.apply {
            mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
            mapView.setBuiltInZoomControls(true)
            mMapController = mapView.getController() as MapController
            mMapController!!.setZoom(13)
            val gPt = GeoPoint(40.69009781402365, -74.04349230056079)
            mMapController!!.setCenter(gPt)
        }
    }
}