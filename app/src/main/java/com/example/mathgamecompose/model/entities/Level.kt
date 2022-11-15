package com.example.mathgamecompose.model.entities

enum class Level {

    TEST, EASY, NORMAL, HARD
}

fun String?.toLevel(): Level {
    return when {
        this == "TEST" -> Level.TEST
        this == "EASY" -> Level.EASY
        this == "NORMAL" -> Level.NORMAL
        this == "HARD" -> Level.HARD
        else -> Level.TEST
    }
}