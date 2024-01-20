package com.cdv.pokemongo.data.api

import android.util.Log
import com.cdv.pokemongo.PokemonListUpdated
import com.cdv.pokemongo.data.model.Pokemon
import com.google.gson.Gson
import java.io.BufferedReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

const val BASE_URL = "https://pokeapi.co/api/v2/"
val POKEMON_LIST: ArrayList<Pokemon> = ArrayList<Pokemon>();
fun getPokemonData(pokemonId: Int) {
    if (pokemonId < 1 || pokemonId > 1025) {
        Log.e("API ERROR", "Selected not existing pokemon");
        return
    }
    Thread {
        val returnedJSON: String = callAPI("/pokemon/${pokemonId}");
        Log.d("RETURNED JSON", returnedJSON)
        handleResponse(Gson().fromJson(returnedJSON, Pokemon::class.java))

        Thread.currentThread().interrupt();
    }.start()
}

fun callAPI(endpoint: String): String {
    var toReturn = ""
    val url = URL(BASE_URL + endpoint);
    val connection = url.openConnection() as HttpsURLConnection;

    if (connection.responseCode == 200) {
        toReturn = BufferedReader(connection.inputStream.reader()).readText();
    } else {
        Log.e("API error", "API error");
    }

    return toReturn
}

fun handleResponse(pokemon: Pokemon) {
    pokemon.showPokemonData();
    POKEMON_LIST.add(pokemon);
    PokemonListUpdated()
}