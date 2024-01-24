package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.layout.Box
import com.cdv.pokemongo.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cdv.pokemongo.Screen
import com.cdv.pokemongo.ui.theme.BackgroundColor
import com.cdv.pokemongo.ui.theme.PrimaryColor

@Composable
fun Profile(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .paint(painterResource(id = R.drawable.fishing_net))

    )
    Column {
        Text(text = "Profile")
        Button(onClick = { navController.navigate(Screen.Main.name) }) {
            Text("Main")
        }

    }
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(8.dp)){Button(onClick = { }) {
        Text("<")
    }
        Button(onClick = { }) {
            Text(">")
        } }



}


