package com.example.mathgamecompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mathgamecompose.ui.screens.SplashScreen
import com.example.mathgamecompose.utils.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToRulesScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN
    ) {
        SplashScreen(
            navigateToRulesScreen = navigateToRulesScreen
        )
    }
}