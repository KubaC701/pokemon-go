package com.cdv.pokemongo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.data.services.LocationService
import com.cdv.pokemongo.ui.composables.Map
import com.cdv.pokemongo.ui.models.PokemonsModel
import com.cdv.pokemongo.ui.models.UserLocationModel
import com.google.android.gms.maps.model.LatLng

@Composable
fun Main(navController: NavHostController = rememberNavController(), userLocationModel: UserLocationModel, pokemonsModel : PokemonsModel = viewModel()) {
    val context = LocalContext.current

    var deviceLatLng by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }

    var hasBeenInitialized by remember {
        mutableStateOf(false)
    }

    fun updateLocation(lat: Double, lon: Double) {
        deviceLatLng = LatLng(lat, lon)

        if(deviceLatLng != userLocationModel.getUserLocation()){
            if(!hasBeenInitialized){
                pokemonsModel.addPokemon(deviceLatLng);
                pokemonsModel.addPokemon(deviceLatLng);
                pokemonsModel.addPokemon(deviceLatLng);

                hasBeenInitialized = true
            }

            userLocationModel.setUserLocation(deviceLatLng);
            pokemonsModel.checkIfPokemonsTooFar(deviceLatLng)
        }
    }

    LocationService().listen(context, ::updateLocation)
    Map(deviceLatLng, navController, pokemonsModel)
}