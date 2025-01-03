package com.example.cleanarchitecturesampleapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturesampleapp.presentation.components.CharacterScreen
import com.example.cleanarchitecturesampleapp.presentation.viewmodel.CharacterViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CharacterScreen.route) {

        composable(Screen.CharacterScreen.route) {
            val viewModel = hiltViewModel<CharacterViewModel>()
            CharacterScreen(modifier = Modifier, viewModel = viewModel)
        }

    }
}