package com.example.mathgamecompose.ui.screens.levels

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.mathgamecompose.R
import com.example.mathgamecompose.model.entities.Level
import com.example.mathgamecompose.ui.SharedViewModel
import com.example.mathgamecompose.ui.theme.LARGE_PADDING
import com.example.mathgamecompose.ui.theme.holo_green_light
import com.example.mathgamecompose.ui.theme.holo_orange_light
import com.example.mathgamecompose.ui.theme.holo_red_light

@Composable
fun LevelsContent(
    navigateToGameScreen: (Level) -> Unit,
    sharedViewModel: SharedViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(all = LARGE_PADDING),
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = LARGE_PADDING),
            text = stringResource(id = R.string.levels_choose_text),
            style = MaterialTheme.typography.h5
        )

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navigateToGameScreen(Level.TEST)
            },
        ) {
            Text(text = stringResource(id = R.string.levels_test_text), color = Color.White)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navigateToGameScreen(Level.EASY)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = holo_green_light)
        ) {
            Text(text = stringResource(id = R.string.levels_easy_text), color = Color.White)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navigateToGameScreen(Level.NORMAL)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = holo_orange_light)
        ) {
            Text(text = stringResource(id = R.string.levels_medium_text), color = Color.White)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navigateToGameScreen(Level.HARD)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = holo_red_light)
        ) {
            Text(text = stringResource(id = R.string.levels_hard_text), color = Color.White)
        }
    }
}