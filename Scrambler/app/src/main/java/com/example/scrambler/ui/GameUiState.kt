package com.example.scrambler.ui

data class GameUiState(
    val currentScrabbleWord: String = "",
    val currentWordCount: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val score: Int = 0,
    val isGameOver: Boolean = false
)
