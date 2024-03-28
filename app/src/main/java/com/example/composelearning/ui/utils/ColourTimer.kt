package com.example.presentation.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/*
Composing Demo with colour : Unknown
Composing timer with colour : Unknown
left 3
left 2
left 1
Composing Demo with colour : Black
Composing timer with colour : Black
Timer ended
[1] buttonColour is Unknown
[2] buttonColorUpdated is Black
[3] colorState is Unknown
 */

@Composable
fun ColourTimer(
    modifier: Modifier = Modifier,
    buttonColour: String
) {

    val timerDurationInSec = 3
    Log.d("#codelab","Composing timer with colour : $buttonColour")
    SideEffect {
        Log.d("#codelab","Recomposition is successful")
    }

    val buttonColorUpdated by rememberUpdatedState(newValue = buttonColour)
    val colorState by remember { mutableStateOf(buttonColour) }

    LaunchedEffect(key1 = Unit, block = {
        startTimer(timerDurationInSec) {
            Log.d("#codelab", "Timer ended")
            Log.d("#codelab","[1] buttonColour is $buttonColour")
            Log.d("#codelab","[2] buttonColorUpdated is $buttonColorUpdated")
            Log.d("#codelab","[3] colorState is $colorState")
        }
    })

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(24.dp))
        Text(text = "Timer:", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))
        Text(colorState)
    }
}

suspend fun startTimer(sec: Int, onTimerEnd: () -> Unit) {
    repeat(sec) {
        Log.d("#codelab", "left ${sec - it}")
        delay(timeMillis = (it * 1000).toLong())
    }

    onTimerEnd()
}
