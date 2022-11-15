package com.example.mathgamecompose.ui.screens.result

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.mathgamecompose.model.entities.GameResult

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ResultScreen(
    gameResult: GameResult,
    onBackPressed: () -> Unit,
    onRetryPressed: () -> Unit,
) {
    BackHandler {
        onBackPressed()
    }

    Scaffold(
        topBar = { ResultTopAppBar() },
        content = { ResultContent(gameResult = gameResult, onRetryPressed = onRetryPressed) }
    )
}