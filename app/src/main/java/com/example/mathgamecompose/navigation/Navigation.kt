package com.example.mathgamecompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mathgamecompose.navigation.destinations.*
import com.example.mathgamecompose.ui.SharedViewModel
import com.example.mathgamecompose.utils.Constants.SPLASH_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
) {

    val screens = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToRulesScreen = screens.splashToRules
        )
        rulesComposable(
            navigateToLevelsScreen = screens.rulesToLevels,
        )
        levelsComposable(
            onBackPressed = screens.splashToRules,
            navigateToGameScreen = screens.levelsToGame,
            sharedViewModel = sharedViewModel
        )
        gameComposable(
            navigateToResultScreen = screens.gameToResult,
            sharedViewModel = sharedViewModel,
            onBackPressed = screens.rulesToLevels

        )
        resultComposable(
            sharedViewModel = sharedViewModel,
            onBackPressed = screens.rulesToLevels,
            onRetryPressed = screens.rulesToLevels
        )
    }
}