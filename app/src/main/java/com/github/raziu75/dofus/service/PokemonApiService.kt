package com.github.raziu75.dofus.service

import com.github.raziu75.dofus.service.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Result<PokemonResponse>

    @GET("pokemon")
    suspend fun getAllPokemon(): Result<List<PokemonResponse>>
}