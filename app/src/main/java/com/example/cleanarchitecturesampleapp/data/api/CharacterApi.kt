package com.example.cleanarchitecturesampleapp.data.api

import com.example.cleanarchitecturesampleapp.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getAllCharcters(): List<CharactersDto>
}