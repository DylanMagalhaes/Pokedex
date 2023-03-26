package com.github.raziu75.dofus.service

import com.github.raziu75.dofus.service.mapper.toModel
import com.github.raziu75.dofus.service.response.PokemonResponse
import com.github.raziu75.dofus.ui.model.PokemonModel

class PokemonRepository(private val service: PokemonApiService) {

    suspend fun getPokemon(id: Int): Result<PokemonResponse> {
        return service.getPokemon(id)

    }

    suspend fun getAllPokemon(): Result<List<PokemonModel>> {
        return service.getAllPokemon()
            .map { pokemonListResponse ->
                pokemonListResponse
                    .filterNot { it.id == 0 }
                    .map { it.toModel() }
            }
    }
}