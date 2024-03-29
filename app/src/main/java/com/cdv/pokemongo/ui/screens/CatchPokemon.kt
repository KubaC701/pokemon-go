package com.cdv.pokemongo.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.cdv.pokemongo.R
import com.cdv.pokemongo.Screen
import com.cdv.pokemongo.ui.composables.AppIconButton
import com.cdv.pokemongo.ui.models.BackpackModel
import com.cdv.pokemongo.ui.models.PokemonDetailsModel
import com.cdv.pokemongo.ui.models.PokemonsModel


@Composable
fun CatchPokemon(
    navController: NavController,
    pokemonId: String,
    backpackModel: BackpackModel = viewModel(),
    pokemonDetailModel: PokemonDetailsModel = viewModel(),
    pokemonModel: PokemonsModel = viewModel(),
) {
    val state by pokemonDetailModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        pokemonDetailModel.fetchDetails(pokemonId.toInt())
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )

    )


    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.pokemon != null) {
            Column {
                Text(
                    state.pokemon!!.name.replaceFirstChar { it.uppercase() },
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 44.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    "Poziom ${state.pokemon!!.level}",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    "Łap nicponia!",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 24.dp, 0.dp, 0.dp)
                )
            }
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = state.pokemon!!.sprites.highRes,
                contentDescription = state.pokemon!!.name
            )

            AppIconButton(
                painterResource(id = R.drawable.fishing_net),
                alt = "Złap pokemona",
                onClick = {
                    navController.navigate(Screen.Main.name) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                    backpackModel.add(state.pokemon!!)
                    pokemonModel.removeSinglePokemon(state.pokemon!!.id)
                },
                fireOnce = true,
                modifier = Modifier.size(80.dp),
                iconModifier = Modifier.padding(8.dp)
            )
        }
    }

}

