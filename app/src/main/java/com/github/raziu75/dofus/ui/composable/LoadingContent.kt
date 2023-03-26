package com.github.raziu75.dofus.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}