package com.cdv.pokemongo.ui.models

import com.cdv.pokemongo.data.model.Pokemon
import com.cdv.pokemongo.data.model.Sprites
import com.cdv.pokemongo.data.model.Stat
import com.cdv.pokemongo.data.model.Stats
import com.cdv.pokemongo.data.model.Type
import com.cdv.pokemongo.data.model.Types
import com.google.android.gms.maps.model.LatLng
import java.net.URL

data class PokemonsState(
    val pokemons: ArrayList<Pokemon> = arrayListOf(
        Pokemon(
            id = 99,
            name = "Charmander",
            sprites = Sprites(
                URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/551.png")
            ),
            stats = arrayListOf(
                Stats(
                    base_stat = 2,
                    effort = 3,
                    stat = Stat(url = URL("https://aaa.com"), name = "AAA")
                )
            ),
            types = arrayListOf(
                Types(
                    type = Type(name = "Fire", url = URL("https://aaa.com")),
                    slot = 1
                )
            ),
            latLng = LatLng(10.0,10.0)
        )
    )
)