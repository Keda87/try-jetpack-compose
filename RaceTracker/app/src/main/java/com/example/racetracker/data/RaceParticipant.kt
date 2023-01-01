package com.example.racetracker.data

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlin.math.max

class RaceParticipant(
    val name: String,
    val maxProgress: Int = 100,
    val progressDelayMilis: Long = 500L,
    private val initialProgress: Int = 0,
    private val progressIncrement: Int = 1,
) {

    init {
        require(maxProgress > 0) { "maxProgress=$maxProgress; must be > 0" }
        require(progressIncrement > 0) { "progressIncrement=$progressIncrement; must be > 0" }
    }

    var currentProgress by mutableStateOf(initialProgress)
        private set

    suspend fun run() {
        try {
            while (currentProgress < maxProgress) {
                delay(progressDelayMilis)
                currentProgress += progressIncrement
            }

            if (currentProgress > maxProgress) {
                currentProgress = maxProgress
            }

        } catch (e: CancellationException) {
            Log.e("RaceParticipant", "$name: ${e.message}")
            throw e // Always re-throw CancellationException.
        }
    }

    fun reset() {
        currentProgress = 0
    }
}

val RaceParticipant.progressFactor: Float
    get() = currentProgress / maxProgress.toFloat()