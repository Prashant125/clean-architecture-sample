package com.example.cleanarchitecturesampleapp

import com.example.cleanarchitecturesampleapp.data.mapper.toCharacter
import kotlin.test.Test
import kotlin.test.assertEquals

class MapperTest {

    @Test
    fun `toCharacter maps CharactersDto to Characters correctly`() {
        val dto = MockData.apiCharacterDto
        val domain = dto.toCharacter()

        assertEquals(dto.actor, domain.actor)
        assertEquals(dto.id, domain.id)
        assertEquals(dto.name, domain.name)
        assertEquals(dto.image, domain.image)
    }
}