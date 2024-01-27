package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cdv.pokemongo.ui.composables.MyPokemon
import com.cdv.pokemongo.ui.models.BackpackModel
import com.cdv.pokemongo.ui.theme.BackgroundColor
import com.cdv.pokemongo.ui.theme.TertiaryColor

@Composable
fun Bag(backpackModel: BackpackModel = viewModel()) {
    val uiState by backpackModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(BackgroundColor)){
        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState(), true)
        ) {
            Spacer(Modifier.padding(4.dp))

            Row(Modifier.height(100.dp).clip(RoundedCornerShape(20.dp)).fillMaxWidth()){
                Box(Modifier.fillMaxSize().background(TertiaryColor), contentAlignment = Alignment.Center){
                    Text(text = "Moje Potwory", fontSize = 36.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.padding(4.dp))
            uiState.pokemons.forEach { pokemon ->
                Row(Modifier.clip(RoundedCornerShape(20.dp))) {
                    MyPokemon(pokemon)
                }
                Spacer(Modifier.padding(2.dp))
            }
        }
    }
}

@Preview
@Composable
fun BagPreview() {
    Bag()
}