package com.cdv.pokemongo.ui.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.cdv.pokemongo.R
import com.cdv.pokemongo.data.model.PokemonOnMap

data class ProfileState(
    val activeProfileIndex: Int = 0
)