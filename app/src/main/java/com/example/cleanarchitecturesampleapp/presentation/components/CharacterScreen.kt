package com.example.cleanarchitecturesampleapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cleanarchitecturesampleapp.presentation.state.CharacterState

@Composable
fun CharacterScreen(modifier: Modifier,characterState: CharacterState) {
    if (characterState.errorMessage.isBlank()) {
        Box(modifier = modifier.fillMaxSize()) {
            Text(text = characterState.errorMessage, modifier = modifier.align(Alignment.Center))
        }
    } else if (characterState.loading) {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }
    }

    if (characterState.characters?.isNotEmpty() == true) {
        LazyColumn {
            val characters = characterState.characters
            items(characters) {
                CharacterItem(modifier = modifier, character = it)
            }
        }
    }
}