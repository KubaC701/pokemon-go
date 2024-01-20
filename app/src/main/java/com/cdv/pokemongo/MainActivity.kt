package com.cdv.pokemongo

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cdv.pokemongo.ui.theme.PokemonGOTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


class MainActivity : ComponentActivity() {
    companion object {
        const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1234
    }
    private val locationPermissionGranted = mutableStateOf(false)
    @Deprecated("Deprecated in Java")

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            locationPermissionGranted.value=true
        }
    }

    private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionGranted.value = true
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PokemonGOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    getLocationPermission()
                    if (locationPermissionGranted.value) {
                        Main()
                    } else {
                        Text("Need permission")
                    }
                    }
                }
            }
        }
    }


@SuppressLint("MissingPermission")
@Composable
fun Main() {
    val context = LocalContext.current
    var deviceLatLng by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }

    fun updateLocation (lat:Double ,lon:Double ) {
        deviceLatLng = LatLng(lat, lon)
    }
    LocationService().start(context, ::updateLocation)

    Map(deviceLatLng)
}

@Composable
fun Map(latLng: LatLng) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = latLng),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    PokemonGOTheme {
        Map(LatLng(52.41586505577246, 16.931699256882602))
    }
}