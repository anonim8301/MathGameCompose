package com.example.mathgamecompose.ui

import android.app.Application
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathgamecompose.R
import com.example.mathgamecompose.model.GameRepo
import com.example.mathgamecompose.model.entities.GameResult
import com.example.mathgamecompose.model.entities.GameSettings
import com.example.mathgamecompose.model.entities.Level
import com.example.mathgamecompose.model.entities.Question
import com.example.mathgamecompose.utils.Constants.COUNT_OF_OPTIONS
import com.example.mathgamecompose.utils.Constants.MILLIS_IN_SECOND
import com.example.mathgamecompose.utils.Constants.SECONDS_IN_MINUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: GameRepo,
    private val application: Application,
) : ViewModel() {

    private var _currentGameSettings: MutableState<GameSettings> =
        mutableStateOf(GameSettings(0, 0, 0, 0))
    val currentGamaSettings = _currentGameSettings

    private var _question: MutableState<Question> =
        mutableStateOf(
            Question(0, 0, listOf(0, 0, 0, 0, 0, 0)))
    val question = _question

    private var _gameResult: MutableState<GameResult> =
        mutableStateOf(
            GameResult(false, 0, 0, currentGamaSettings.value))
    val gameResult = _gameResult

    private var _formattedTime: MutableState<String> = mutableStateOf("")
    val formattedTime = _formattedTime

    private var _percentOfRightAnswer: MutableState<Int> = mutableStateOf(0)
    val percentOfRightAnswer = _percentOfRightAnswer

    private var _minPercent: MutableState<Int> = mutableStateOf(0)
    val minPercent = _minPercent

    private var _rightAnswersCount: MutableState<String> = mutableStateOf("")
    val rightAnswersCount = _rightAnswersCount

    private var _enoughCountOfRightAnswers: MutableState<Boolean> = mutableStateOf(false)
    val enoughCountOfRightAnswers = _enoughCountOfRightAnswers

    private var _enoughPercentOfRightAnswers: MutableState<Boolean> = mutableStateOf(false)
    val enoughPercentOfRightAnswers = _enoughPercentOfRightAnswers

    private var _gameOver: MutableState<Boolean> = mutableStateOf(false)
    val gameOver = _gameOver

    private var timer: CountDownTimer? = null
    private var countOfRightAnswer = 0
    private var countOfQuestions = 0

    fun startGame() {
        generateQuestion()
        startTimer()
        updateProgress()
    }

    private fun updateProgress() {
        val percent = calculatePercentOfRightAnswers()
        _percentOfRightAnswer.value = percent
        rightAnswersCount.value = String.format(
            application.getString(R.string.game_right_answers_count),
            countOfRightAnswer,
            _currentGameSettings.value.minCountOfRightAnswers
        )
        _enoughCountOfRightAnswers.value =
            countOfRightAnswer >= currentGamaSettings.value.minCountOfRightAnswers
        _enoughPercentOfRightAnswers.value =
            percent >= currentGamaSettings.value.minPercentOfRightAnswers
    }

    private fun calculatePercentOfRightAnswers(): Int {
        if (countOfQuestions == 0) {
            return 0
        }
        return (countOfRightAnswer / countOfQuestions.toDouble() * 100).toInt()
    }

    fun chooseRightAnswer(number: Int) {
        checkAnswer(number)
        updateProgress()
        generateQuestion()
    }

    private fun checkAnswer(number: Int) {
        val rightAnswer = question.value.rightAnswer
        if (number == rightAnswer) {
            countOfRightAnswer++
        }
        countOfQuestions++
    }

    private fun generateQuestion() {
        viewModelScope.launch {
            _question.value =
                repository.generateQuestion(currentGamaSettings.value.maxSumValue, COUNT_OF_OPTIONS)
            _minPercent.value = currentGamaSettings.value.minPercentOfRightAnswers
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(
            _currentGameSettings.value.gameTimeInSeconds * MILLIS_IN_SECOND,
            MILLIS_IN_SECOND
        ) {
            override fun onTick(millisUntilFinished: Long) {
                _formattedTime.value = formatTime(millisUntilFinished)
            }

            override fun onFinish() {
                finishGame()
            }
        }
        timer?.start()
    }

    private fun formatTime(millisUntilFinished: Long): String {
        val seconds = millisUntilFinished / MILLIS_IN_SECOND
        val minutes = seconds / SECONDS_IN_MINUTE
        val leftSeconds = seconds - (minutes * SECONDS_IN_MINUTE)
        return String.format("%02d:%02d", minutes, leftSeconds)
    }

    fun getGameSetting(level: Level) {
        viewModelScope.launch {
            _currentGameSettings.value = repository.getGameSettings(level)
        }
    }

    private fun finishGame() {
        _gameResult.value = GameResult(
            enoughCountOfRightAnswers.value && enoughPercentOfRightAnswers.value,
            countOfRightAnswer,
            countOfQuestions,
            currentGamaSettings.value
        )
        gameOver.value = true
    }

    fun stopTimer() {
        timer?.cancel()
    }

    fun resetAll() {
        countOfQuestions = 0
        countOfRightAnswer = 0
        _percentOfRightAnswer.value = 0
        _gameOver.value = false
        _percentOfRightAnswer.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}