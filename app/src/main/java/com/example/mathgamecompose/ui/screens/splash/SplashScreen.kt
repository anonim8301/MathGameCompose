package com.example.mathgamecompose.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mathgamecompose.R
import com.example.mathgamecompose.model.GameRepo
import com.example.mathgamecompose.ui.theme.SPLASHSCREEN_LOGO_SIZE
import com.example.mathgamecompose.ui.theme.splashScreenBackgroundColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToRulesScreen: () -> Unit,
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val offsetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp, animationSpec = tween(1000)
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(1000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000L)
        navigateToRulesScreen()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashScreenBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(SPLASHSCREEN_LOGO_SIZE)
                .offset(y = offsetState)
                .alpha(alphaState),
            painter = painterResource(id = R.drawable.ic_brain),
            contentDescription = stringResource(id = R.string.splash_screen_icon)
        )
    }

}
