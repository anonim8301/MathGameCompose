package com.example.mathgamecompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mathgamecompose.model.entities.Level
import com.example.mathgamecompose.ui.SharedViewModel
import com.example.mathgamecompose.ui.screens.levels.LevelsScreen
import com.example.mathgamecompose.utils.Constants.LEVELS_SCREEN

fun NavGraphBuilder.levelsComposable(
    onBackPressed: () -> Unit,
    navigateToGameScreen: (Level) -> Unit,
    sharedViewModel: SharedViewModel,
) {
    composable(
        route = LEVELS_SCREEN
    ) {
        LevelsScreen(
            onBackPressed = onBackPressed,
            navigateToGameScreen = navigateToGameScreen,
            sharedViewModel = sharedViewModel
        )
    }
}