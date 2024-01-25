package com.cdv.pokemongo.data.model

import com.google.android.gms.maps.model.LatLng
import org.json.JSONObject
import kotlin.random.Random

class PokemonOnMap(pokemonJson : JSONObject, latLng: LatLng) : Pokemon(pokemonJson){
    var latLng : LatLng = setLocation(latLng);

    fun setLocation(latLng: LatLng): LatLng {
        val randomGenerator = Random(System.currentTimeMillis());
        val baseVal = 0.01
        val latDiff = randomGenerator.nextDouble(baseVal*-3, baseVal*3);
        val lngDiff = randomGenerator.nextDouble(baseVal*-1, baseVal)
        val lat = (latLng.latitude + latDiff)
        val lng = (latLng.longitude + lngDiff)
        val location = LatLng(lat, lng);

        return location
    }
}