package com.cdv.pokemongo

import android.util.Log
import java.net.URL

class Pokemon (
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val stats: ArrayList<Stats>,
    val types: ArrayList<Types>
){
    fun showPokemonData(showDetails: Boolean = false){
        Log.d("POKEMON OBJECT DATA", this.id.toString());
        Log.d("POKEMON OBJECT DATA", this.name);
        Log.d("POKEMON OBJECT DATA", this.sprites.front_default.toString());

        if(showDetails){
            for(stat : Stats in this.stats){
                Log.d("POKEMON OBJECT DATA", stat.base_stat.toString())
                Log.d("POKEMON OBJECT DATA", stat.effort.toString())
                Log.d("POKEMON OBJECT DATA", stat.stat.name)
                Log.d("POKEMON OBJECT DATA", stat.stat.url.toString())
            }

            for(type : Types in this.types){
                Log.d("POKEMON OBJECT DATA", type.slot.toString())
                Log.d("POKEMON OBJECT DATA", type.type.name)
                Log.d("POKEMON OBJECT DATA", type.type.url.toString())
            }
        }
    }
}

class Sprites(
    val front_default: URL
)

class Stats(
    val base_stat: Int,
    val effort : Int,
    val stat : Stat
)

class Stat(
    val name: String,
    val url : URL
)

class Types(
    val slot : Int,
    val type : Type
)

class Type(
    val name : String,
    val url : URL
)

