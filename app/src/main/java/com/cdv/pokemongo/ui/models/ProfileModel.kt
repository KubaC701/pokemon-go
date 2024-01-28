package com.cdv.pokemongo.ui.models

import android.widget.RemoteViews.RemoteCollectionItems
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.R
import com.cdv.pokemongo.data.model.PokemonOnMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileModel : ViewModel() {
    val profileAvatarItems = listOf(
        R.drawable.p0,
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3
    )
    private val _uiState = MutableStateFlow(ProfileState())
    val uiState: StateFlow<ProfileState> = _uiState.asStateFlow()
    var profileNumber:  Int = 0

    fun previousProfile(){
        if(profileNumber>0){
            profileNumber = profileNumber - 1
            updateAvatarInUI()
        }
    }
    fun nextProfile(){
        if(profileNumber<profileAvatarItems.size-1){
            profileNumber = profileNumber + 1
            updateAvatarInUI()
        }
    }
    fun updateAvatarInUI(){
        _uiState.update { currentState ->
            currentState.copy(
                activeProfileIndex = profileNumber
            )
        }
    }
}

