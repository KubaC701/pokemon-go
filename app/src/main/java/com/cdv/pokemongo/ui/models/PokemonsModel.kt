package com.cdv.pokemongo.ui.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.data.api.getPokemonData
import com.cdv.pokemongo.data.model.Pokemon
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class PokemonsModel : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonsState())
    val uiState: StateFlow<PokemonsState> = _uiState.asStateFlow()
    private var pokemons: ArrayList<Pokemon> = arrayListOf<Pokemon>();
    init{
        for(i in 1..3){
            addPokemon()
        }
    }
    fun addPokemon(){
        Thread{
            val pokemonJSON = getPokemonData((1..1025).random())
            Log.d("RETURNED JSON", pokemonJSON)
            handleResponse(Gson().fromJson(pokemonJSON, Pokemon::class.java))

            Thread.currentThread().interrupt();
        }.start()
    }

    fun handleResponse(newPokemon: Pokemon) {
        newPokemon.showPokemonData();
        pokemons.add(newPokemon)
        _uiState.update {
            currentState ->
                currentState.copy(
                    pokemons = pokemons
            )
        }
    }

    fun getSimilarLocation(latLng : LatLng) : LatLng{
        val randomGenerator = Random(System.currentTimeMillis())
        val baseVal = 0.5
        val divideVal = 400
        val lat = latLng.latitude + randomGenerator.nextDouble(baseVal*-2/divideVal, baseVal*2/divideVal)
        val lng = latLng.longitude + randomGenerator.nextDouble(baseVal*-1/divideVal, baseVal/divideVal)

        Log.d("LATLNG DATA LAT", lat.toString())
        Log.d("LATLNG DATA LNG", lng.toString())
        return LatLng(lat, lng)
    }
}