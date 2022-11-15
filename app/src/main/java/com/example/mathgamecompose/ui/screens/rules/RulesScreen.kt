package com.example.mathgamecompose.ui.screens.rules

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.mathgamecompose.ui.screens.rules.RulesAppBar
import com.example.mathgamecompose.ui.screens.rules.RulesContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RulesScreen(
    navigateToLevelsScreen: () -> Unit,
) {
    val activity = (LocalContext.current as? Activity)
    BackHandler {
        activity?.finish()
    }

    Scaffold(
        topBar = { RulesAppBar() },
        content = { RulesContent(
            navigateToLevelsScreen = navigateToLevelsScreen
        ) }
    )

}
