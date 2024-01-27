package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cdv.pokemongo.ui.composables.PokemonImage
import com.cdv.pokemongo.ui.models.BackpackModel
import com.cdv.pokemongo.ui.theme.BackgroundColor

@Composable
fun Bag(backpackModel: BackpackModel = viewModel()) {
    val uiState by backpackModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(5.dp)
            .verticalScroll(rememberScrollState(), true)
    ) {
        val pokemonModifier = Modifier.weight(1f)
        val rowModifier = Modifier.height(200.dp)
        val spacerModifier = Modifier.padding(2.dp)

        uiState.pokemons.forEach { pokemon ->
            Spacer(spacerModifier)

            Row(rowModifier, Arrangement.SpaceAround) {
                PokemonImage(
                    pokemonModifier,
                    BackgroundColor,
                    pokemon.sprites.highRes
                )
                Text(text = "Level: ${pokemon.level}")
            }
        }
    }
}

@Preview
@Composable
fun BagPreview() {
    Bag()
}