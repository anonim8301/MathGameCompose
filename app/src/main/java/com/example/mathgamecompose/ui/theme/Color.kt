package com.example.mathgamecompose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val holo_green_light = Color(0Xff99cc00)
val holo_orange_light = Color(0Xffffbb33)
val holo_red_light = Color(0Xffff4444)
val holo_purple_light = Color(0Xffaa66cc)
val holo_blue_light = Color(0Xff33b5e5)
val holo_bright_blue_light = Color(0Xff00ddff)

val game_num_in_rectangle = Color(0XFF018786)
val game_num_in_circle = Color(0XFF3700B3)


val Colors.splashScreenBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else Color.Black

