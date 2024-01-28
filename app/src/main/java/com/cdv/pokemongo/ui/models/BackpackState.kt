package com.cdv.pokemongo.ui.models

import com.cdv.pokemongo.data.model.Pokemon

data class BackpackState(
    val pokemons: ArrayList<Pokemon> = arrayListOf(),
    val bestPokemon: Pokemon? = null
)