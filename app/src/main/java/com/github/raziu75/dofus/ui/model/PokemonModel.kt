package com.github.raziu75.dofus.ui.model

data class PokemonModel(
    val id: Int,
    val lifePoints: Int,
    val japName: String,
    val frenchName: String,
    val attack: Int,
    val defence: Int,
    val illustration: Illustration,
    val types: List<Type>
) {
    data class Type(
        val name: String,
        val image: String
    )

    data class Illustration(
        val regularUrl: String,
        val shinyUrl: String?,
    )
}
