package com.github.raziu75.dofus.service.mapper

import com.github.raziu75.dofus.service.response.PokemonResponse
import com.github.raziu75.dofus.ui.model.PokemonModel
import com.github.raziu75.dofus.ui.model.PokemonModel.Illustration

fun PokemonResponse.toModel(): PokemonModel {
    val statPokemon = this.stats
    val spritePokemon = this.sprite

    return PokemonModel(
        id = this.id,
        frenchName = this.name.fr,
        japName = this.name.jp,
        attack = statPokemon.atk,
        defence = statPokemon.df,
        illustration = Illustration(
            regularUrl = spritePokemon.regular,
            shinyUrl = spritePokemon.shiny,
        ),
        lifePoints = statPokemon.hp,
        types = this.types.map { it.toModel() }
    )
}

fun PokemonResponse.TypeResponse.toModel() = PokemonModel.Type(name, image)