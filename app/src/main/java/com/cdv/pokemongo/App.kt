package com.cdv.pokemongo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

    NavHost(navController = navController, startDestination = Screen.Main.name) {
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
        composable(Screen.CatchPokemon.name) {
            CatchPokemon(navController)
        }
    }

}