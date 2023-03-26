package com.github.raziu75.dofus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import com.github.raziu75.dofus.service.PokemonRepository
import com.github.raziu75.dofus.service.RetrofitHelper
import com.github.raziu75.dofus.ui.MainScreen
import com.github.raziu75.dofus.ui.model.PokemonModel

class MainActivity : ComponentActivity() {

    private val repository = PokemonRepository(service = RetrofitHelper().buildApiService())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var pokemonList by remember { mutableStateOf<List<PokemonModel>?>(null) }

            LaunchedEffect(Unit) {
                repository.getAllPokemon()
                    .onSuccess {
                        pokemonList = it
                        println(it)
                    }
            }

            MaterialTheme(colorScheme = darkColorScheme()) {
                MainScreen(pokemonList = pokemonList)
            }
        }
    }
}

