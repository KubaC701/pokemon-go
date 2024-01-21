package com.cdv.pokemongo.ui.models

import com.cdv.pokemongo.data.model.Pokemon

data class PokemonsState(
    val pokemons: ArrayList<Pokemon> = arrayListOf<Pokemon>()
)