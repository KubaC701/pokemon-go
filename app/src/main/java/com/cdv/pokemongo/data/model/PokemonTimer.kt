package com.cdv.pokemongo.data.model

import com.cdv.pokemongo.ui.models.PokemonsModel
import com.cdv.pokemongo.ui.models.UserLocationModel
import java.util.TimerTask

open class PokemonTimer(userLocationModel: UserLocationModel, pokemonsModel: PokemonsModel) : TimerTask() {
    val userLocationModel = userLocationModel
    val pokemonsModel = pokemonsModel

    override fun run() {
            pokemonsModel.addPokemon(userLocationModel.getUserLocation())
    }
}