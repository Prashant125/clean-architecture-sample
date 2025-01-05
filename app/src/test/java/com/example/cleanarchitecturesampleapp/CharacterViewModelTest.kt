package com.example.cleanarchitecturesampleapp

import com.example.cleanarchitecturesampleapp.domain.usecase.GetAllCharacterUseCase
import com.example.cleanarchitecturesampleapp.presentation.state.CharacterState
import com.example.cleanarchitecturesampleapp.presentation.viewmodel.CharacterViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.runTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class CharacterViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val useCase: GetAllCharacterUseCase = mockk()
    private lateinit var viewModel: CharacterViewModel

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CharacterViewModel(useCase)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain() // Reset Main dispatcher after tests
    }

    @Test
    fun `fetchAllCharacters updates state with characters on success`() = runTest {
        val characters = listOf(MockData.domainCharacter)
        coEvery { useCase.invoke() } returns characters

        viewModel.fetchAllCharacters()

        // Advance coroutine to allow state to update
        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value
        assertEquals(CharacterState(characters = characters), uiState)
    }

    @Test
    fun `fetchAllCharacters updates state with error on failure`() = runTest {
        val errorMessage = "Something went wrong"
        coEvery { useCase.invoke() } throws Exception(errorMessage)

        viewModel.fetchAllCharacters()

        // Advance coroutine to allow state to update
        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value
        assertEquals(CharacterState(errorMessage = errorMessage), uiState)
    }

    @Test
    fun `fetchAllCharacters updates state with loading`() = runTest {
        val characters = listOf(MockData.domainCharacter)
        coEvery { useCase.invoke() } coAnswers {
            // Simulate a delay
            testDispatcher.scheduler.advanceTimeBy(1000)
            characters
        }

        viewModel.fetchAllCharacters()

        // Assert loading state
        assertEquals(CharacterState(loading = true), viewModel.uiState.value)

        // Advance coroutine to finish
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert success state
        val uiState = viewModel.uiState.value
        assertEquals(CharacterState(characters = characters), uiState)
    }
}