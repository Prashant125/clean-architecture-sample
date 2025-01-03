package com.example.cleanarchitecturesampleapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesampleapp.domain.usecase.GetAllCharacterUseCase
import com.example.cleanarchitecturesampleapp.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterUseCase: GetAllCharacterUseCase): ViewModel() {
    private val _uiState = MutableStateFlow(CharacterState())
    val uiState: StateFlow<CharacterState>
        get() = _uiState

    init {
        fetchAllCharacters()
    }

    private fun fetchAllCharacters() {
        _uiState.value = CharacterState().copy(loading = true)
        viewModelScope.launch {
            try {
                 val result = characterUseCase.invoke()
                _uiState.value = CharacterState().copy(characters = result)
            } catch (e:Exception) {
                _uiState.value = CharacterState().copy(errorMessage = "Something went wrong")
            }
        }
    }
}