package com.cdv.pokemongo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cdv.pokemongo.R
import com.cdv.pokemongo.ui.composables.ChangeProfileButton
import com.cdv.pokemongo.ui.composables.Title
import com.cdv.pokemongo.ui.models.BackpackModel
import com.cdv.pokemongo.ui.models.ProfileModel
import com.cdv.pokemongo.ui.theme.BackgroundColor
import com.cdv.pokemongo.ui.theme.PrimaryColor

@Composable

fun Profile(profileModel: ProfileModel, backpackModel: BackpackModel) {
    val profileState by profileModel.uiState.collectAsState()
    val backpackState by backpackModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    )

    Column(modifier = Modifier.padding(16.dp)) {

        Title(text = "Twój profil")


        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(24.dp))
                .background(PrimaryColor)
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            val choosenAvatar = profileModel.profileAvatarItems[profileState.activeProfileIndex]
            ChangeProfileButton(
                painterResource(id = R.drawable.previous_button),
                alt = "previous",
                onClick = { profileModel.previousProfile() })
            Image(
                painter = painterResource(id = choosenAvatar),
                contentDescription = "avatar",
            )
            ChangeProfileButton(
                painterResource(id = R.drawable.next_button),
                alt = "next",
                onClick = { profileModel.nextProfile() })
        }
        if (backpackState.bestPokemon != null) {
            Spacer(modifier = Modifier.padding(32.dp))
            Title(text = "Twój buddy")
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = backpackState.bestPokemon!!.sprites.highRes,
                contentDescription = backpackState.bestPokemon!!.name
            )
        }
    }
}