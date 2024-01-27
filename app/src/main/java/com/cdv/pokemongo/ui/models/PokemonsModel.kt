package com.cdv.pokemongo.ui.models

import androidx.lifecycle.ViewModel
import com.cdv.pokemongo.data.api.getPokemonData
import com.cdv.pokemongo.data.model.PokemonOnMap
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import kotlin.math.abs

class PokemonsModel() : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonsState())
    val uiState: StateFlow<PokemonsState> = _uiState.asStateFlow()
    private var pokemons: ArrayList<PokemonOnMap> = arrayListOf<PokemonOnMap>();

    fun addPokemon(latLng: LatLng) {
        Thread {
            val pokemonJSON = getPokemonData((1..1025).random())
            handleResponse(JSONObject(pokemonJSON), latLng)

            Thread.currentThread().interrupt();
        }.start()
    }

    fun handleResponse(pokemonJSON: JSONObject, latLng: LatLng) {
        val newPokemon = PokemonOnMap(pokemonJSON, latLng)
        newPokemon.showPokemonData();

        pokemons.add(newPokemon)
        updatePokemonsInUI()
    }

    fun checkIfPokemonsTooFar(latLng: LatLng){
        val pokemonIndexesToRemove : ArrayList<Int> = arrayListOf<Int>();
        pokemons.forEachIndexed { index, pokemon ->
            if(pokemon.latLng == null) return;

            if(abs((abs(pokemon.latLng!!.latitude) - abs(latLng.latitude)) +
                (abs(pokemon.latLng!!.longitude) - abs(latLng.longitude))) > 2){
                pokemonIndexesToRemove.add(index);
            }
        }

        if(pokemonIndexesToRemove.size > 0) removeMultiplePokemons(pokemonIndexesToRemove);
    }

    fun removeMultiplePokemons(indexes : ArrayList<Int>){
        for(i in indexes.size - 1 downTo 0){
            pokemons.removeAt(indexes[i]);
        }

        updatePokemonsInUI();
    }

    fun removeSinglePokemon(pokemonId : Int){
        pokemons.removeIf{it.id == pokemonId}
        updatePokemonsInUI()
    }

    fun updatePokemonsInUI(){
        _uiState.update { currentState ->
            currentState.copy(
                pokemons = ArrayList(pokemons)
            )
        }
    }

    fun getPokemonListSize() : Int{
        return pokemons.size
    }
}