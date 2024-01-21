package com.cdv.pokemongo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cdv.pokemongo.ui.theme.Green40

@Composable
fun PokemonImage(
        modifier : Modifier = Modifier,
        color : Color = Green40,
        url : String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png"
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color)
    ){
        AsyncImage(
            model = url,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
fun PokemonImagePreview(){
    PokemonImage()
}