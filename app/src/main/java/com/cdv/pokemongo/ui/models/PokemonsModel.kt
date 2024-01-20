package com.cdv.pokemongo.ui.models

import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.data.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonsModel : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonsState())
    val uiState: StateFlow<PokemonsState> = _uiState.asStateFlow()
    private lateinit var pokemons: ArrayList<Pokemon>

}