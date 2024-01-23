package com.cdv.pokemongo.data.model

import android.util.Log
import org.json.JSONObject

class Pokemon(pokemonJson: JSONObject) {
    val id: Int = pokemonJson.getInt("id")
    val name: String = pokemonJson.getString("name")
    val sprites: Sprites = Sprites(
        pokemonJson.getJSONObject("sprites").getString("front_default"),
        pokemonJson.getJSONObject("sprites").getJSONObject("other")
            .getJSONObject("official-artwork").getString("front_default")
    )
    val level: Int = (1..10).random()
    fun showPokemonData() {
        Log.d("POKEMON OBJECT DATA", this.id.toString());
        Log.d("POKEMON OBJECT DATA", this.name);
        Log.d("POKEMON OBJECT DATA", this.sprites.lowRes);
        Log.d("POKEMON OBJECT DATA", this.sprites.highRes);
    }
}

class Sprites(
    val lowRes: String,
    val highRes: String
)

