package com.example.mathgamecompose.ui.screens.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mathgamecompose.R
import com.example.mathgamecompose.model.entities.GameResult
import com.example.mathgamecompose.ui.theme.LARGEST_PADDING
import com.example.mathgamecompose.ui.theme.LARGE_PADDING

@Composable
fun ResultContent(
    onRetryPressed: () -> Unit,
    gameResult: GameResult,
) {
    val emoji: Int = if (gameResult.winOrNot) R.drawable.ic_smile else R.drawable.ic_sad
    val scoredPercentage = if (gameResult.countOfQuestions == 0) 0 else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(top = LARGE_PADDING, start = LARGE_PADDING, end = LARGE_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(all = LARGEST_PADDING)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ) {
            Image(
                painterResource(emoji),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = LARGE_PADDING),
            text = String.format(
                stringResource(id = R.string.result_required_score),
                gameResult.gameSettings.minCountOfRightAnswers),
            style = MaterialTheme.typography.h6
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = LARGE_PADDING),
            text = String.format(
                stringResource(id = R.string.result_score_answers),
                gameResult.countOfRightAnswers),
            style = MaterialTheme.typography.h6
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = LARGE_PADDING),
            text = String.format(
                stringResource(id = R.string.result_required_percentage),
                gameResult.gameSettings.minPercentOfRightAnswers),
            style = MaterialTheme.typography.h6
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = LARGE_PADDING),
            text = String.format(
                stringResource(id = R.string.result_score_percentage),
                scoredPercentage),
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onRetryPressed()
            },
        ) {
            Text(text = stringResource(id = R.string.result_retry_game))
        }
    }

}