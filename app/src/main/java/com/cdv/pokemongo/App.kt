package com.cdv.pokemongo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.ui.composables.BottomNavigationBar
import com.cdv.pokemongo.ui.screens.Bag
import com.cdv.pokemongo.ui.screens.CatchPokemon
import com.cdv.pokemongo.ui.screens.Encyclopedia
import com.cdv.pokemongo.ui.screens.Main
import com.cdv.pokemongo.ui.screens.Profile
import com.cdv.pokemongo.ui.screens.Settings

enum class Screen() {
    Main,
    Bag,
    Profile,
    Settings,
    Encyclopedia,
    CatchPokemon
}

@Composable
fun App(navController: NavHostController = rememberNavController()) {
    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Main.name) {
                Main(navController)
            }
            composable(Screen.Bag.name) {
                Bag(navController)
            }
            composable(Screen.Profile.name) {
                Profile(navController)
            }
            composable(Screen.Settings.name) {
                Settings(navController)
            }
            composable(Screen.Encyclopedia.name) {
                Encyclopedia(navController)
            }
            composable("${Screen.CatchPokemon.name}/{pokemonId}") { backStackEntry ->
                CatchPokemon(
                    navController,
                    checkNotNull(backStackEntry.arguments?.getString("pokemonId"))
                )
            }
        }
    }
}