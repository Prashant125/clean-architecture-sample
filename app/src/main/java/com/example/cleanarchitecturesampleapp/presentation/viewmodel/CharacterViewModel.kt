package com.example.cleanarchitecturesampleapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesampleapp.core.common.Resources
import com.example.cleanarchitecturesampleapp.domain.model.Characters
import com.example.cleanarchitecturesampleapp.domain.usecase.getAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterUseCase: getAllCharacterUseCase): ViewModel() {

    private val _uiState = MutableLiveData<Resources<List<Characters>>>()
    val uiState: LiveData<Resources<List<Characters>>> = _uiState

    init {
        fetchAllCharacters()
    }

    fun fetchAllCharacters() {
        _uiState.postValue(Resources.Loading())

        viewModelScope.launch {
            try {
                val result = characterUseCase.invoke()
                _uiState.postValue(Resources.Success(result))
            } catch (e:Exception) {
                _uiState.postValue(Resources.Error("something went wrong"))
            }
        }
    }

}