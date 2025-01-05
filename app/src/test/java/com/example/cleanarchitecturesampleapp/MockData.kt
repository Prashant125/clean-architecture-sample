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

    // Mock CharactersDto object
    val apiCharacterDto = CharactersDto(
        actor = "Daniel Radcliffe",
        alive = true,
        alternateActors = listOf(),
        alternateNames = listOf("The Boy Who Lived"),
        ancestry = "Half-blood",
        dateOfBirth = "1980-07-31",
        eyeColour = "Green",
        gender = "Male",
        hairColour = "Black",
        hogwartsStaff = false,
        hogwartsStudent = true,
        house = "Gryffindor",
        id = "1",
        image = "https://example.com/harry_potter.jpg",
        name = "Harry Potter",
        patronus = "Stag",
        species = "Human",
        wand = wand,
        wizard = true,
        yearOfBirth = 1980
    )

    // Expected Characters object after mapping
    val domainCharacter = Characters(
        actor = "Daniel Radcliffe",
        id = "1",
        name = "Harry Potter",
        image = "https://example.com/image.jpg"
    )
}