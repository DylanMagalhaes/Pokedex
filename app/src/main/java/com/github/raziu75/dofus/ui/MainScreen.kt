package com.github.raziu75.dofus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.raziu75.dofus.ui.model.PokemonModel
import com.github.raziu75.dofus.ui.composable.LoadingContent
import com.github.raziu75.dofus.ui.composable.PokemonCard

@Composable
fun MainScreen(
    pokemonList: List<PokemonModel>?,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (pokemonList == null) {
            LoadingContent(modifier = Modifier.fillMaxSize())
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(pokemonList) { pokemon ->
                    PokemonCard(pokemon = pokemon)
                }
            }
        }
    }
}