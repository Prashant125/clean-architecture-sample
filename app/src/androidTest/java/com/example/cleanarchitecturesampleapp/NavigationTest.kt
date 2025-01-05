package com.example.cleanarchitecturesampleapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cleanarchitecturesampleapp.presentation.MainActivity
import com.example.cleanarchitecturesampleapp.presentation.navigation.Navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            // Initialize the TestNavHostController
            navController = TestNavHostController(composeTestRule.activity)

            // Pass the navController to Navigation composable
            Navigation(navController = navController)
        }
    }

    @Test
    fun testStartDestinationIsCharacterScreen() {
        composeTestRule.runOnIdle {
            // Assert that the start destination is the CharacterScreen route
            assert(navController.currentDestination?.route == "character_screen")
        }
    }
}