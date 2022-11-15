package com.example.mathgamecompose.ui.screens.game

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathgamecompose.model.entities.Question
import com.example.mathgamecompose.ui.theme.*

@Composable
fun GameContent(
    enoughCountOfRightAnswers: Boolean,
    enoughPercentOfRightAnswers: Boolean,
    onAnswerClicked: (Int) -> Unit,
    time: String,
    question: Question,
    rightAnswersCount: String,
    percentOfRightAnswer: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        GameTimer(time = time)
        Spacer(modifier = Modifier.weight(0.1f))
        TheGame(question)
        CountOfRightAnswers(
            rightAnswersCount = rightAnswersCount,
            enoughCountOfRightAnswers = enoughCountOfRightAnswers
        )
        Spacer(modifier = Modifier.weight(0.1f))
        GameProgressBar(
            percentOfRightAnswer = percentOfRightAnswer,
            enoughPercentOfRightAnswers = enoughPercentOfRightAnswers
        )
        GameOptions(
            question = question,
            onAnswerClicked = onAnswerClicked
        )
    }
}

@Composable
fun GameTimer(
    time: String,
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.h5,
            text = time
        )
    }
}

@Composable
fun TheGame(
    question: Question,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LARGE_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(GAME_CIRCLE_SIZE)
                .clip(CircleShape)
                .background(game_num_in_circle),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 48.sp,
                    letterSpacing = 0.sp
                ),
                fontWeight = FontWeight.Bold,
                text = question.sum.toString()
            )
        }

        Row() {
            Box(
                modifier = Modifier
                    .padding(MEDIUM_PADDING)
                    .size(GAME_RECTANGLE_SIZE)
                    .clip(RectangleShape)
                    .background(game_num_in_rectangle),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 48.sp,
                        letterSpacing = 0.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    text = question.visibleNum.toString()
                )
            }
            Box(
                modifier = Modifier
                    .padding(MEDIUM_PADDING)
                    .size(GAME_RECTANGLE_SIZE)
                    .clip(RectangleShape)
                    .background(game_num_in_rectangle),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 48.sp,
                        letterSpacing = 0.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    text = "?"
                )
            }
        }
    }
}

@Composable
fun CountOfRightAnswers(
    enoughCountOfRightAnswers: Boolean,
    rightAnswersCount: String,
) {
    val rightColor: Color =
        if (enoughCountOfRightAnswers) holo_green_light else holo_red_light

    Text(
        modifier = Modifier.padding(LARGE_PADDING),
        text = rightAnswersCount,
        color = rightColor
    )


}

@Composable
fun GameProgressBar(
    percentOfRightAnswer: Int,
    enoughPercentOfRightAnswers: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val progress: Int = percentOfRightAnswer
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .height(30.dp)
                .background(Color.Gray)
                .width(300.dp)
        ) {
            val progressBarColor: List<Color> =
                if (enoughPercentOfRightAnswers) {
                    listOf(
                        Color(0xFF0F9D58),
                        Color(0xF055CA4D)
                    )
                }else {
                    listOf(
                        Color(0xFF0F9D58),
                        Color(0xF055CA4D)
                    )
                }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .height(30.dp)
                    .background(
                        Brush.horizontalGradient(
                            progressBarColor
                        )
                    )
                    .width(300.dp * progress / 100)
            )
            Text(
                text = "$progress %",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }
}

@Composable
fun GameOptions(
    onAnswerClicked: (Int) -> Unit,
    question: Question,
) {
    Column(
        modifier = Modifier.padding(top = LARGEST_PADDING)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(RectangleShape)
                    .background(holo_green_light)
                    .clickable {
                        onAnswerClicked(question.options[0])
                    },
                contentAlignment = Alignment.Center
            ) {
                GameOptionTextComponent(question.options[0])
            }

            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(RectangleShape)
                    .background(holo_orange_light)
                    .clickable {
                        onAnswerClicked(question.options[1])
                    },
                contentAlignment = Alignment.Center
            ) {
                GameOptionTextComponent(question.options[1])
            }

            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(RectangleShape)
                    .background(holo_purple_light)
                    .clickable {
                        onAnswerClicked(question.options[2])
                    },
                contentAlignment = Alignment.Center
            ) {
                GameOptionTextComponent(question.options[2])
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(RectangleShape)
                    .background(holo_blue_light)
                    .clickable {
                        onAnswerClicked(question.options[3])
                    },
                contentAlignment = Alignment.Center
            ) {
                GameOptionTextComponent(question.options[3])
            }

            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(RectangleShape)
                    .background(holo_red_light)
                    .clickable {
                        onAnswerClicked(question.options[4])
                    },
                contentAlignment = Alignment.Center
            ) {
                GameOptionTextComponent(question.options[4])
            }

            Box(
                modifier = Modifier
                    .weight(2f)
                    .clip(RectangleShape)
                    .background(holo_bright_blue_light)
                    .clickable {
                        onAnswerClicked(question.options[5])
                    },
                contentAlignment = Alignment.Center,

                ) {
                GameOptionTextComponent(question.options[5])
            }
        }
    }
}

@Composable
fun GameOptionTextComponent(option: Int) {
    Text(
        modifier = Modifier,
        style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            letterSpacing = 0.sp
        ),
        text = option.toString()
    )
}
