package com.example.cleanarchitecturesampleapp

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.cleanarchitecturesampleapp.presentation.components.CharacterScreen
import com.example.cleanarchitecturesampleapp.presentation.state.CharacterState
import org.junit.Rule
import org.junit.Test

class CharacterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoadingState() {
        composeTestRule.setContent {
            CharacterScreen(
                modifier = Modifier,
                characterState = CharacterState(loading = true)
            )
        }

        composeTestRule.onNodeWithText("Loading...").assertIsDisplayed()
    }

    @Test
    fun testErrorState() {
        val errorMessage = "Something went wrong"
        composeTestRule.setContent {
            CharacterScreen(
                modifier = Modifier,
                characterState = CharacterState(errorMessage = errorMessage)
            )
        }

        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
    }

    @Test
    fun testCharacterList() {
        val characters = listOf(MockData.domainCharacter)
        composeTestRule.setContent {
            CharacterScreen(
                modifier = Modifier,
                characterState = CharacterState(characters = characters)
            )
        }

        composeTestRule.onNodeWithText(characters.first().name).assertIsDisplayed()
    }
}