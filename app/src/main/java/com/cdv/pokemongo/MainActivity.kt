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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.data.api.POKEMON_LIST
import com.cdv.pokemongo.data.api.getPokemonData
import com.cdv.pokemongo.data.services.LocationService
import com.cdv.pokemongo.ui.composables.MapMarker
import com.cdv.pokemongo.ui.theme.PokemonGOTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties


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
        getPokemonData((1..1025).random())
        getPokemonData((1..1025).random())
        getPokemonData((1..1025).random())
    }
}


@Composable
fun Map(latLng: LatLng, navController: NavHostController = rememberNavController()) {
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = MapProperties(
            mapStyleOptions = MapStyleOptions(stringResource(R.string.map_config))
        ),
        cameraPositionState = CameraPositionState(position = CameraPosition(latLng, 18f, 0f, 0f))
    ) {
        MapMarker(
            latLng,
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/551.png",
            onClick = {
                navController.navigate(Screen.CatchPokemon.name)
            }
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

fun PokemonListUpdated() {
    Log.d("POKEMON LIST UPDATED", POKEMON_LIST.size.toString());
}