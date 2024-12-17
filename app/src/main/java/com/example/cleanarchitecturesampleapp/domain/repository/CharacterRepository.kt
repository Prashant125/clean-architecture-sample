package com.example.cleanarchitecturesampleapp.domain.repository

import com.example.cleanarchitecturesampleapp.domain.model.Characters

interface CharacterRepository {
    suspend fun getAllCharacters(): List<Characters>
}