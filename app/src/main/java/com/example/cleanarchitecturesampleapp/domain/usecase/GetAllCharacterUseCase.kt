package com.example.cleanarchitecturesampleapp.domain.usecase

import com.example.cleanarchitecturesampleapp.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend operator fun invoke() = repository.getAllCharacters()
}