package com.cdv.pokemongo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.cdv.pokemongo.data.services.LocationService
import com.cdv.pokemongo.ui.theme.PokemonGOTheme


class MainActivity : ComponentActivity() {
    private val locationService = LocationService();

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        locationService.onRequestPermissionsResult(requestCode, grantResults)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            PokemonGOTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    locationService.getLocationPermission(this)
                    if (locationService.locationPermissionGranted.value) {
                        App()
                    } else {
                        Text("Need permission")
                    }
                }
            }
        }
    }
}
