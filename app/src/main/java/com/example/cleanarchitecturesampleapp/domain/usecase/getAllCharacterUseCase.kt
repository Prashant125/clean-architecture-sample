package com.example.cleanarchitecturesampleapp.domain.usecase

import com.example.cleanarchitecturesampleapp.domain.model.Characters
import com.example.cleanarchitecturesampleapp.domain.repository.CharacterRepository
import javax.inject.Inject

class getAllCharacterUseCase @Inject constructor(val repository: CharacterRepository) {

    suspend operator fun invoke() = repository.getAllCharacters()
}