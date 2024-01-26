package com.cdv.pokemongo.ui.models;

import com.google.android.gms.maps.model.LatLng;

data class UserLocationState(
    val latLng : LatLng = LatLng(0.0,0.0)
)