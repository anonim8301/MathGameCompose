package com.example.mathgamecompose.ui.screens.game

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mathgamecompose.R
import com.example.mathgamecompose.ui.theme.topAppBarBackgroundColor
import com.example.mathgamecompose.ui.theme.topAppBarContentColor

@Composable
fun GameTopAppBar() {

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.game_app_bar),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}