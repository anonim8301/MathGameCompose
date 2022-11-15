package com.example.mathgamecompose.model.entities

data class GameResult(
    val winOrNot: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings,
)