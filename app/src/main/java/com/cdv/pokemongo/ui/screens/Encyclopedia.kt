package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.cdv.pokemongo.Screen

@Composable
fun Encyclopedia(navController: NavController) {
    Column {
        Text(text = "Encyclopedia")
        Button(onClick = { navController.navigate(Screen.Main.name) }) {
            Text("Main")
        }
    }
}