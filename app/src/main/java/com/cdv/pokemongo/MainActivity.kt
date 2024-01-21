package com.cdv.pokemongo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cdv.pokemongo.data.services.LocationService
import com.cdv.pokemongo.ui.composables.Map
import com.cdv.pokemongo.ui.theme.PokemonGOTheme
import com.google.android.gms.maps.model.LatLng


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
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    locationService.getLocationPermission(this)
                    if (locationService.locationPermissionGranted.value) {
                        Main()
                    } else {
                        Text("Need permission")
                    }
                }
            }
        }
    }
}


@Composable
fun Main() {
    val context = LocalContext.current
    var deviceLatLng by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }

    fun updateLocation(lat: Double, lon: Double) {
        deviceLatLng = LatLng(lat, lon)
    }
    LocationService().listen(context, ::updateLocation)
    Map(deviceLatLng)
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    PokemonGOTheme {
        Map(LatLng(52.41586505577246, 16.931699256882602))
    }
}
