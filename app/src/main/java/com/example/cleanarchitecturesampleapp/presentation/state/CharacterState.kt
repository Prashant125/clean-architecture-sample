package com.example.cleanarchitecturesampleapp.presentation.state

import com.example.cleanarchitecturesampleapp.domain.model.Characters

data class CharacterState(
    val characters: List<Characters>? = emptyList(),
    val errorMessage: String = "",
    val loading: Boolean = false
)