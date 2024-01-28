package com.cdv.pokemongo.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Box
import com.cdv.pokemongo.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cdv.pokemongo.ui.composables.ChangeProfileButton
import com.cdv.pokemongo.ui.composables.Title
import com.cdv.pokemongo.ui.models.ProfileModel
import com.cdv.pokemongo.ui.theme.BackgroundColor
import com.cdv.pokemongo.ui.theme.PrimaryColor
import com.cdv.pokemongo.ui.theme.TertiaryColor

@Composable

fun Profile(profileModel:ProfileModel) {
    val profileState by profileModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor))

    Column(modifier = Modifier .padding(16.dp)) {
        Row(
            Modifier
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()){
            Box(
                Modifier
                    .fillMaxSize()
                    .background(TertiaryColor), contentAlignment = Alignment.Center){
                Title(text = "Zmiana awatara")
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(24.dp),)
                .background(PrimaryColor)
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            val choosenAvatar=profileModel.profileAvatarItems[profileState.activeProfileIndex]
            ChangeProfileButton(painterResource(id = R.drawable.previous_button), alt = "previous", onClick = {profileModel.previousProfile()})
            Image(painter = painterResource(id = choosenAvatar), contentDescription = "avatar")
            ChangeProfileButton(painterResource(id = R.drawable.next_button), alt = "next", onClick = {profileModel.nextProfile()})
        }
    }
}