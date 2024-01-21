package com.cdv.pokemongo.data.api

import android.util.Log
import java.io.BufferedReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

const val BASE_URL = "https://pokeapi.co/api/v2/"
fun getPokemonData(pokemonId: Int) : String {

    if (pokemonId < 1 || pokemonId > 1025) {
        Log.e("API ERROR", "Selected not existing pokemon");
    }

    return callAPI("/pokemon/${pokemonId}");
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
