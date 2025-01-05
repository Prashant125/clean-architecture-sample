package com.example.cleanarchitecturesampleapp

import com.example.cleanarchitecturesampleapp.data.dto.CharactersDto
import com.example.cleanarchitecturesampleapp.data.dto.Wand
import com.example.cleanarchitecturesampleapp.domain.model.Characters

object MockData {
    // Mock Wand object for CharactersDto
    private val wand = Wand(
        wood = "Holly",
        core = "Phoenix Feather",
        length = 11.0
    )
    // Expected Characters object after mapping
    val domainCharacter = Characters(
        actor = "Daniel Radcliffe",
        id = "1",
        name = "Harry Potter",
        image = "https://example.com/image.jpg"
    )
}