package com.example.scrambler.ui

data class GameUiState(
    val currentScrabbleWord: String = "",
    val isGuessedWordWrong: Boolean = false
)
