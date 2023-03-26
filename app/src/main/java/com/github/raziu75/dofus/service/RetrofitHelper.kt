package com.github.raziu75.dofus.service

import com.github.raziu75.dofus.service.adapter.ResultCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    private val BASE_URL = "https://api-pokemon-fr.vercel.app/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // utiliser Gson pour la conversion
        .addCallAdapterFactory(ResultCallAdapterFactory()) // utiliser Result
        .build()


    fun buildApiService(): PokemonApiService {
        return retrofit.create(PokemonApiService::class.java)
    }
}