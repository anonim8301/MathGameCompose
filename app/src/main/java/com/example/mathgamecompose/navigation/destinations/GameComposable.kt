package com.example.mathgamecompose.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mathgamecompose.model.entities.toLevel
import com.example.mathgamecompose.ui.SharedViewModel
import com.example.mathgamecompose.ui.screens.game.GameScreen
import com.example.mathgamecompose.utils.Constants.GAME_SCREEN
import com.example.mathgamecompose.utils.Constants.LEVEL_ARGUMENT_KEY

fun NavGraphBuilder.gameComposable(
    onBackPressed: () -> Unit,
    navigateToResultScreen: () -> Unit,
    sharedViewModel: SharedViewModel,
) {
    composable(
        route = GAME_SCREEN,
        arguments = listOf(navArgument(LEVEL_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { NavBackStackEntry ->
        val level = NavBackStackEntry.arguments?.getString(LEVEL_ARGUMENT_KEY).toLevel()
        sharedViewModel.getGameSetting(level)
        LaunchedEffect(key1 = level) {
            sharedViewModel.startGame()
        }
        GameScreen(
            onBackPressed = onBackPressed,
            sharedViewModel = sharedViewModel,
            navigateToResultScreen = navigateToResultScreen,
            onAnswerClicked = {
                sharedViewModel.chooseRightAnswer(it)
            }
        )
    }
}