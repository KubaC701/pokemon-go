package com.cdv.pokemongo.ui.models

import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.data.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BackpackModel() : ViewModel() {
    private val pokemons = ArrayList<Pokemon>()
    private val _uiState = MutableStateFlow(BackpackState())
    val uiState: StateFlow<BackpackState> = _uiState.asStateFlow()

    fun add(newPokemon: Pokemon) {
        pokemons.add(newPokemon)
        val bestPokemon = pokemons.sortedByDescending {
            it.level
        }[0]
        _uiState.update { currentState ->
            currentState.copy(
                pokemons = pokemons,
                bestPokemon = bestPokemon
            )
        }
    }
}