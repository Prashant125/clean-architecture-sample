package com.example.cleanarchitecturesampleapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import com.example.cleanarchitecturesampleapp.core.common.Resources
import com.example.cleanarchitecturesampleapp.domain.model.Characters
import com.example.cleanarchitecturesampleapp.presentation.viewmodel.CharacterViewModel

@Composable
fun CharacterScreen(modifier: Modifier,viewModel: CharacterViewModel) {

    val uiState by viewModel.uiState.observeAsState(initial = Resources.Loading())

    when(uiState) {
        is Resources.Error -> {
            Box(modifier = modifier.fillMaxSize()) {
                Text(text = (uiState as Resources.Error<List<Characters>>).message.toString(), modifier = modifier.align(Alignment.Center))
            }
        }
        is Resources.Loading -> {
            Box(modifier = modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
            }
        }
        is Resources.Success -> {
            LazyColumn {
                val characters =  (uiState as Resources.Success).data ?: emptyList()
                items(characters) {
                    CharacterItem(modifier = modifier,character = it)
                }
            }
        }
    }
}