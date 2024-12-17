package com.example.cleanarchitecturesampleapp.data.repository

import com.example.cleanarchitecturesampleapp.data.api.CharacterApi
import com.example.cleanarchitecturesampleapp.data.mapper.toCharacter
import com.example.cleanarchitecturesampleapp.domain.model.Characters
import com.example.cleanarchitecturesampleapp.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(private val api: CharacterApi) : CharacterRepository {
    override suspend fun getAllCharacters(): List<Characters> {
        try {
            return api.getAllCharcters().map { it.toCharacter() }
        } catch (e: Exception) {
            throw Exception("something went wrong")
        }
    }
}