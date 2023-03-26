package com.github.raziu75.dofus.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.github.raziu75.dofus.ui.model.PokemonModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(
    pokemon: PokemonModel,
    modifier: Modifier = Modifier
) {
    var pokemonDraw by remember { mutableStateOf(pokemon.illustration.regularUrl) }

    Surface(
        modifier = modifier,
        shadowElevation = 2.dp,
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 4.dp,
        onClick = {
            when (pokemonDraw) {
                pokemon.illustration.regularUrl -> pokemon.illustration.shinyUrl?.let {
                    pokemonDraw = it
                }

                pokemon.illustration.shinyUrl -> pokemonDraw = pokemon.illustration.regularUrl
            }
        }
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "#" + pokemon.id.toString() + " " + pokemon.frenchName + "\n  ${pokemon.japName}",
                style = MaterialTheme.typography.titleLarge
            )

            Image(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                painter = rememberAsyncImagePainter(pokemonDraw),
                contentDescription = null
            )

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Hp: " + pokemon.lifePoints)
                    Text(text = "Atk: " + pokemon.attack)
                    Text(text = "Def: " + pokemon.defence)
                }

                Column {
                    pokemon.types.forEach { type ->
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = rememberAsyncImagePainter(type.image),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}


