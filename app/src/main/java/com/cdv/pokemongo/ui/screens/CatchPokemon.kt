package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cdv.pokemongo.ui.models.PokemonDetailsModel

@Composable
fun CatchPokemon(
    navController: NavController,
    pokemonId: String,
    pokemonModel: PokemonDetailsModel = viewModel(),
) {
    val state by pokemonModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        pokemonModel.fetchDetails(pokemonId.toInt())
    }


    Column {
        if (state.pokemon != null) {
            Text(state.pokemon!!.name, fontSize = 36.sp)
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = state.pokemon!!.sprites.highRes,
                contentDescription = state.pokemon!!.name
            )
            Button(onClick = {}) {
                Text(text = "Catch")
            }

        }
    }
}