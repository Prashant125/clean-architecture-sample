package com.example.cleanarchitecturesampleapp.data.mapper

import com.example.cleanarchitecturesampleapp.data.dto.CharactersDto
import com.example.cleanarchitecturesampleapp.domain.model.Characters


fun CharactersDto.toCharacter(): Characters {
    return Characters(actor,id,name,image)
}