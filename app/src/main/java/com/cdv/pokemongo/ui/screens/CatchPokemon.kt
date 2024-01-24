package com.cdv.pokemongo.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cdv.pokemongo.ui.models.BackpackModel
import com.cdv.pokemongo.R
import com.cdv.pokemongo.ui.composables.AppIconButton
import com.cdv.pokemongo.ui.models.PokemonDetailsModel


@Composable
fun CatchPokemon(
    navController: NavController,
    pokemonId: String,
    backpackModel: BackpackModel = viewModel(),
    pokemonModel: PokemonDetailsModel = viewModel(),
) {
    val state by pokemonModel.uiState.collectAsState()
    val backgroundImage = painterResource (id = R.drawable.background)

    LaunchedEffect(Unit) {
        pokemonModel.fetchDetails(pokemonId.toInt())
    }


        Box(
            modifier = Modifier.fillMaxSize()
                .fillMaxSize()
                    .paint(painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds)

            )


        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.pokemon != null) {
                Text(state.pokemon!!.name, fontSize = 44.sp)
                Text("Łap nicponia!", textAlign = TextAlign.Center, fontSize = 24.sp)
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = state.pokemon!!.sprites.highRes,
                    contentDescription = state.pokemon!!.name
                )


                AppIconButton(painterResource(id = R.drawable.fishing_net), alt = "Settings", onClick = { backpackModel.add(state.pokemon!!) })




            }
        }

}

