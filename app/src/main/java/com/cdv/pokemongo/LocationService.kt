package com.cdv.pokemongo

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.IBinder
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class LocationService : Service() {

    override fun onCreate() {
        ContextCompat.startForegroundService(this, Intent(this, LocationService::class.java))

        super.onCreate()
    }

    companion object {
        const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1234
    }

    val locationPermissionGranted = mutableStateOf(false)


    fun onRequestPermissionsResult(
        requestCode: Int,
        grantResults: IntArray
    ) {

        if (requestCode == PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            locationPermissionGranted.value = true
        }
    }

    fun getLocationPermission(activity: Activity) {
        if (ContextCompat.checkSelfPermission(
                activity,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionGranted.value = true

        } else {
            ActivityCompat.requestPermissions(
                activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )

        }
    }

    fun listen(context: Context, updateCallback: (lat: Double, lon: Double) -> Unit) {
        LocationHelper().startListeningUserLocation(
            context, object : MyLocationListener {
                override fun onLocationChanged(location: Location?) {
                    if (location != null) {
                        updateCallback(location.latitude, location.longitude)
                    }
                }
            })
        return
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}