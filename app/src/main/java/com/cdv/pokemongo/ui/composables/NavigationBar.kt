package com.cdv.pokemongo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cdv.pokemongo.R
import com.cdv.pokemongo.Screen
import com.cdv.pokemongo.ui.theme.SecondaryColor
import com.cdv.pokemongo.ui.theme.TertiaryColor


data class BottomNavItem(val route: String, val icon: Painter, val label: String)




@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Row(
        Modifier
            .fillMaxWidth()
            .background(TertiaryColor)
            .padding(8.dp, 16.dp), Arrangement.SpaceBetween

    )   {

        val BottomNavItems = listOf(
            BottomNavItem(Screen.Profile.name, painterResource (id = R.drawable.usericon), "Profile"),
            BottomNavItem(Screen.Main.name, painterResource (id = R.drawable.earthicon), "Game"),
            BottomNavItem(Screen.Bag.name, painterResource (id = R.drawable.bagpackicon), "Backpack")
        )

        BottomNavItems.forEach { item ->
            IconButton(
                onClick = {
                    if (currentRoute == item.route) return@IconButton;
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = SecondaryColor
                )
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