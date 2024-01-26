package com.cdv.pokemongo.ui.models;

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserLocationModel() : ViewModel() {

    private val _uiState = MutableStateFlow(UserLocationState())
    val uiState: StateFlow<UserLocationState> = _uiState.asStateFlow()
    var userLatLng : LatLng = LatLng(0.0,0.0)

    fun setUserLocation(latLng: LatLng){
        userLatLng = latLng;
        _uiState.update { currentState ->
            currentState.copy(
                latLng = userLatLng
            )
        }
    }

    fun getUserLocation() : LatLng{
        return userLatLng;
    }
}