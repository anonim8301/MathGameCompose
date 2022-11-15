package com.example.mathgamecompose.ui.screens.rules

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mathgamecompose.R
import com.example.mathgamecompose.ui.theme.LARGEST_PADDING
import com.example.mathgamecompose.ui.theme.LARGE_PADDING
import com.example.mathgamecompose.ui.theme.MEDIUM_PADDING

@Composable
fun RulesContent(
    navigateToLevelsScreen: () -> Unit,
) {

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
                painterResource(R.drawable.ic_brain),
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
            text = stringResource(id = R.string.rules_text_1),
            style = MaterialTheme.typography.h5
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MEDIUM_PADDING),
            text = stringResource(id = R.string.rules_text_2),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navigateToLevelsScreen()
            },
        ) {
            Text(text = stringResource(id = R.string.rules_text_3))
        }
    }

}

@Preview
@Composable
fun RulesContentPreview() {
    RulesContent(navigateToLevelsScreen = { })
}