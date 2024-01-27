package com.cdv.pokemongo.ui.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.data.api.getPokemonData
import com.cdv.pokemongo.data.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject

class PokemonDetailsModel() : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonDetailsState())
    val uiState: StateFlow<PokemonDetailsState> = _uiState.asStateFlow()

    fun fetchDetails(pokemonId: Int) {
        Thread {
            val pokemonJSON = getPokemonData(pokemonId)
            Log.d("RETURNED JSON", pokemonJSON)
            handleResponse(JSONObject(pokemonJSON))

            Thread.currentThread().interrupt();
        }.start()
    }

    private fun handleResponse(pokemonJSON: JSONObject) {
        val newPokemon = Pokemon(pokemonJSON)
        newPokemon.showPokemonData();

        _uiState.update { currentState ->
            currentState.copy(
                pokemon = newPokemon
            )
        }
    }
}