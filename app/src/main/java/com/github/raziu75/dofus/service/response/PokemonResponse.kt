package com.github.raziu75.dofus.service.response

import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @SerializedName("name") val name: NameResponse,
    @SerializedName("pokedexId") val id: Int,
    @SerializedName("stats") val stats: StatsResponse,
    @SerializedName("types") val types: List<TypeResponse>,
    @SerializedName("sprites") val sprite: SpriteResponse

) {
    data class NameResponse(
        @SerializedName("fr") val fr: String,
        @SerializedName("jp") val jp: String
    )

    data class StatsResponse(
        @SerializedName("atk") val atk: Int,
        @SerializedName("def") val df: Int,
        @SerializedName("hp") val hp: Int
    )

    data class TypeResponse(
        @SerializedName("name") val name: String,
        @SerializedName("image") val image: String
    )

    data class SpriteResponse(
        @SerializedName("regular") val regular: String,
        @SerializedName("shiny") val shiny: String
    )

}
