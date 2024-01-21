package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cdv.pokemongo.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.ui.composables.PokemonImage
import com.cdv.pokemongo.ui.theme.Green80

@Composable
fun Bag(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .verticalScroll(rememberScrollState(), true)
    ){
        val pokemonModifier = Modifier.weight(1f)
        val rowModifier = Modifier.height(200.dp)
        val spacerModifier = Modifier.padding(2.dp)

        for(i in 1..5){
            Spacer(spacerModifier)
            Row(rowModifier,Arrangement.SpaceAround){
                PokemonImage(pokemonModifier, Green80, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/36.png")
                Spacer(spacerModifier)
                PokemonImage(pokemonModifier, Green80)
            }
        }
        Button(onClick = { navController.navigate(Screen.Main.name) }) {
            Text("Main")
        }
    }
}

@Preview
@Composable
fun BagPreview(){
    Bag(navController = rememberNavController())
}