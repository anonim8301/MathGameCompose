package com.example.mathgamecompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mathgamecompose.ui.screens.rules.RulesScreen
import com.example.mathgamecompose.utils.Constants.RULES_SCREEN

fun NavGraphBuilder.rulesComposable(
    navigateToLevelsScreen: () -> Unit
) {
    composable(
        route = RULES_SCREEN
    ) {
        RulesScreen(
            navigateToLevelsScreen = navigateToLevelsScreen
        )
    }
}