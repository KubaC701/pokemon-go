package com.cdv.pokemongo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.Map
import com.cdv.pokemongo.data.services.LocationService
import com.google.android.gms.maps.model.LatLng

@Composable
fun Main(navController: NavHostController = rememberNavController()) {
    val context = LocalContext.current
    var deviceLatLng by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }

    fun updateLocation(lat: Double, lon: Double) {
        deviceLatLng = LatLng(lat, lon)
    }
    LocationService().listen(context, ::updateLocation)
    Map(deviceLatLng, navController)
}