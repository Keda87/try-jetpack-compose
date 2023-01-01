package com.example.racetracker.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.racetracker.R
import com.example.racetracker.data.RaceParticipant
import com.example.racetracker.data.progressFactor
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun RaceTrackerApp(modifier: Modifier = Modifier) {
    var raceInProgress by remember { mutableStateOf(false) }
    val playerOne = remember {
        RaceParticipant(name = "Player 1", progressIncrement = 4)
    }
    val playerTwo = remember {
        RaceParticipant(name = "Player 2", progressIncrement = 9)
    }

    if (raceInProgress) {
        LaunchedEffect(playerOne, playerTwo) {
            coroutineScope {
                launch { playerOne.run() }
                launch { playerTwo.run() }
            }
            raceInProgress = false
        }
    }

    RaceTrackerScreen(
        player1 = playerOne,
        player2 = playerTwo,
        isRaceInProgress = raceInProgress,
        onStartOrPauseClicked = { raceInProgress = it },
    )
}

@Composable
fun RaceTrackerScreen(
    player1: RaceParticipant,
    player2: RaceParticipant,
    isRaceInProgress: Boolean,
    onStartOrPauseClicked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h3,
        )
        Image(painter = painterResource(id = R.drawable.ic_walk), contentDescription = null)
        ProgressIndicatorComponent(data = player1)
        ProgressIndicatorComponent(data = player2)
        Row(modifier = Modifier.padding(5.dp)) {
            Button(
                onClick = { onStartOrPauseClicked(!isRaceInProgress) },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 2.5.dp)
            ) {
                Text(
                    text = when (isRaceInProgress) {
                        true -> stringResource(id = R.string.pause)
                        false -> stringResource(id = R.string.start)
                    }
                )
            }
            Button(
                onClick = {
                    player1.reset()
                    player2.reset()
                    onStartOrPauseClicked(false)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 2.5.dp)
            ) {
                Text(text = stringResource(id = R.string.reset))
            }
        }
    }
}

@Composable
fun ProgressIndicatorComponent(data: RaceParticipant) {
    Row(
        modifier = Modifier.padding(15.dp),
    ) {
        Text(text = data.name)
        Column(modifier = Modifier.padding(start = 5.dp, end = 5.dp)) {
            LinearProgressIndicator(
                progress = data.progressFactor,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Row {
                Text(text = stringResource(id = R.string.progress_percentage, data.currentProgress))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = stringResource(id = R.string.progress_percentage, 100))
            }
        }
    }
}