package com.example.mathgamecompose.ui.screens.game

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.mathgamecompose.ui.SharedViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GameScreen(
    onBackPressed: () -> Unit,
    navigateToResultScreen: () -> Unit,
    sharedViewModel: SharedViewModel,
    onAnswerClicked: (Int) -> Unit,
) {
    val time by sharedViewModel.formattedTime
    val question by sharedViewModel.question
    val rightAnswersCount by sharedViewModel.rightAnswersCount
    val gameOver by sharedViewModel.gameOver
    val percentOfRightAnswer by sharedViewModel.percentOfRightAnswer
    val enoughCountOfRightAnswers by sharedViewModel.enoughCountOfRightAnswers
    val enoughPercentOfRightAnswers by sharedViewModel.enoughPercentOfRightAnswers

    if (gameOver) {
        navigateToResultScreen()
        sharedViewModel.resetAll()
    }

    BackHandler {
        onBackPressed()
        sharedViewModel.resetAll()
        sharedViewModel.stopTimer()
    }

    Scaffold(
        topBar = { GameTopAppBar() },
        content = {
            GameContent(
                onAnswerClicked = onAnswerClicked,
                time = time,
                question = question,
                rightAnswersCount = rightAnswersCount,
                percentOfRightAnswer = percentOfRightAnswer,
                enoughCountOfRightAnswers = enoughCountOfRightAnswers,
                enoughPercentOfRightAnswers = enoughPercentOfRightAnswers
            )
        }
    )
}