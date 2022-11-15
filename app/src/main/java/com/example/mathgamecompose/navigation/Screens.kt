package com.example.mathgamecompose.navigation

import androidx.navigation.NavController
import com.example.mathgamecompose.model.entities.GameResult
import com.example.mathgamecompose.model.entities.Level
import com.example.mathgamecompose.utils.Constants.RULES_SCREEN
import com.example.mathgamecompose.utils.Constants.SPLASH_SCREEN

class Screens(navController: NavController) {
    val splashToRules: () -> Unit = {
        navController.navigate("rules") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }
    val rulesToLevels: () -> Unit = {
        navController.navigate("levels") {
        }
    }

    val levelsToGame: (Level) -> Unit = { level ->
        navController.navigate("game/${level.name}")
    }

    val gameToResult: () -> Unit = {
        navController.navigate("result")
    }
}