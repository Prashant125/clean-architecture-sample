package com.example.cleanarchitecturesampleapp

import com.example.cleanarchitecturesampleapp.data.api.CharacterApi
import com.example.cleanarchitecturesampleapp.data.mapper.toCharacter
import com.example.cleanarchitecturesampleapp.data.repository.CharacterRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class CharacterRepositoryImplTest {

    private val api = mockk<CharacterApi>()
    private val repository = CharacterRepositoryImpl(api)

    @Test
    fun `getAllCharacters returns list of Characters when API call succeeds`() = runTest {
        val apiResponse = listOf(MockData.apiCharacterDto)
        coEvery { api.getAllCharcters() } returns apiResponse
            val result = repository.getAllCharacters()
            assertEquals(apiResponse.map { it.toCharacter() }, result)
    }

    @Test(expected = Exception::class)
    fun `getAllCharacters throws exception when API call fails`() = runTest {
        coEvery { api.getAllCharcters() } throws Exception("API error")

        repository.getAllCharacters()
    }
}