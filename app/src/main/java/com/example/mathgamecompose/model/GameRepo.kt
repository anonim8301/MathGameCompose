package com.example.mathgamecompose.model

import com.example.mathgamecompose.model.entities.GameSettings
import com.example.mathgamecompose.model.entities.Level
import com.example.mathgamecompose.model.entities.Question

interface GameRepo {

   suspend fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int,
    ): Question
   suspend fun getGameSettings(level: Level): GameSettings
}