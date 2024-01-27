package com.cdv.pokemongo.ui.models

import com.cdv.pokemongo.data.model.PokemonOnMap

data class PokemonsState(
    val pokemons: ArrayList<PokemonOnMap> = arrayListOf<PokemonOnMap>()
)