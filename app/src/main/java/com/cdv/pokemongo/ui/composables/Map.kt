package com.cdv.pokemongo.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cdv.pokemongo.R
import com.cdv.pokemongo.Screen
import com.cdv.pokemongo.ui.models.PokemonsModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties

@Composable
fun Map(latLng: LatLng, navController: NavController, pokemonsModel: PokemonsModel = viewModel()) {
    val pokemonsState by pokemonsModel.uiState.collectAsState()

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = MapProperties(
            mapStyleOptions = MapStyleOptions(stringResource(R.string.map_config))
        ),
        cameraPositionState = CameraPositionState(position = CameraPosition(latLng, 18f, 0f, 0f))
    ) {
        pokemonsState.pokemons.forEach { pokemon ->
            Log.d("LATLNG DATA POKEMON", pokemon.name)
            MapMarker(
                pokemonsModel.getSimilarLocation(latLng),
                pokemon.sprites.lowRes,
                onClick = {
                    navController.navigate(Screen.CatchPokemon.name)
                }
            )
        }
    }

}
