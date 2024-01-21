package com.cdv.pokemongo.ui.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.data.api.getPokemonData
import com.cdv.pokemongo.data.model.Pokemon
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PokemonDetailsModel() : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonDetailsState())
    val uiState: StateFlow<PokemonDetailsState> = _uiState.asStateFlow()

    fun fetchDetails(pokemonId: Int) {
        Thread {
            try {
                val pokemonJSON = getPokemonData(pokemonId)
                Log.d("RETURNED JSON", pokemonJSON)
                handleResponse(Gson().fromJson(pokemonJSON, Pokemon::class.java))
            } catch (error: Throwable) {
                Log.e("Fetch", error.toString())
            }


            Thread.currentThread().interrupt();
        }.start()
    }

    fun handleResponse(newPokemon: Pokemon) {
        newPokemon.showPokemonData();
        _uiState.update { currentState ->
            currentState.copy(
                pokemon = newPokemon
            )
        }
    }
}