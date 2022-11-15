package com.example.mathgamecompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mathgamecompose.ui.SharedViewModel
import com.example.mathgamecompose.ui.screens.result.ResultScreen
import com.example.mathgamecompose.utils.Constants.RESULT_SCREEN

fun NavGraphBuilder.resultComposable(
    onBackPressed: () -> Unit,
    onRetryPressed: () -> Unit,
    sharedViewModel: SharedViewModel,
) {
    composable(
        route = RESULT_SCREEN
    ) {
        val gameResult = sharedViewModel.gameResult

        ResultScreen(
            gameResult = gameResult.value,
            onBackPressed = onBackPressed,
            onRetryPressed = onRetryPressed
        )
    }
}