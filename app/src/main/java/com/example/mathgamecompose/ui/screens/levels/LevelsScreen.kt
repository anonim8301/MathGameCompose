package com.example.mathgamecompose.ui.screens.levels

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.mathgamecompose.model.entities.Level
import com.example.mathgamecompose.ui.SharedViewModel
import com.example.mathgamecompose.ui.screens.levels.LevelsContent
import com.example.mathgamecompose.ui.screens.levels.LevelsTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LevelsScreen(
    onBackPressed: () -> Unit,
    navigateToGameScreen : (Level) ->Unit,
    sharedViewModel: SharedViewModel,
) {

    BackHandler {
        onBackPressed()
    }

    Scaffold(
        topBar = { LevelsTopAppBar() },
        content = { LevelsContent(
            navigateToGameScreen = navigateToGameScreen,
            sharedViewModel = sharedViewModel
        ) }
    )
}
