package com.cdv.pokemongo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.Screen
import com.cdv.pokemongo.ui.theme.PrimaryColor


data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)

val BottomNavItems = listOf(
    BottomNavItem(Screen.Profile.name, Icons.Default.Person, "Profile"),
    BottomNavItem(Screen.Main.name, Icons.Default.Home, "Game"),
    BottomNavItem(Screen.Bag.name, Icons.Default.Menu, "Backpack")
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Row(
        Modifier
            .fillMaxWidth()
            .background(PrimaryColor)
            .padding(8.dp, 16.dp), Arrangement.SpaceBetween

    ) {

        BottomNavItems.forEach { item ->
            IconButton(
                onClick = {
                    if (currentRoute == item.route) return@IconButton;
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
            ) {
                Icon(item.icon, contentDescription = item.label)
            }
        }
    }
}

@Preview
@Composable
fun NavigationBarPreview() {
    BottomNavigationBar(rememberNavController())
}