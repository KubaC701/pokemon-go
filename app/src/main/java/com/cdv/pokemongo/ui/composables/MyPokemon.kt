package com.cdv.pokemongo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import com.cdv.pokemongo.data.model.Pokemon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cdv.pokemongo.ui.theme.PrimaryColor
import com.cdv.pokemongo.ui.theme.TertiaryColor


@Composable
fun MyPokemon(pokemon : Pokemon) {
    Box(modifier = Modifier
        .background(PrimaryColor)
        .fillMaxSize()
        .padding(15.dp)
    ){
        Row(Modifier.fillMaxSize(), verticalAlignment =  Alignment.CenterVertically){
            PokemonImage(
                modifier = Modifier
                    .weight(1.8f)
                    .width(100.dp)
                    .height(170.dp),
                TertiaryColor,
                url = pokemon.sprites.highRes
            )
            Spacer(Modifier.padding(10.dp))
            Column(Modifier.weight(2f), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = pokemon.name.replaceFirstChar(Char::titlecase), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.padding(10.dp))
                Text(text = "Level: ${pokemon.level}", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.padding(5.dp))
                LinearProgressIndicator(progress = pokemon.level.toFloat()/10, color = Color.Green)
            }
        }
    }
}