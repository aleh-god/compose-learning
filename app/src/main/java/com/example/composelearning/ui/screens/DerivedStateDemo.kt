package com.example.composelearning.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.commons.loadProgress
import kotlinx.coroutines.launch

@Composable
fun DerivedStateDemo(
    modifier: Modifier = Modifier,
) {

    Log.d("#codelab","DerivedStateDemo: start")
    SideEffect {
        Log.d("#codelab","DerivedStateDemo: Recomposition is successful")
    }

    var restart by remember { mutableIntStateOf(0) }
    var counter by remember { mutableIntStateOf(0) }
    val slowCounter by remember { derivedStateOf { counter / 10 } }

    LaunchedEffect(key1 = restart) {
        launch {
            loadProgress(0) { progress ->
                counter = progress
            }
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { restart++ }) {
            Text(text = "Restart")
        }
        Spacer(Modifier.height(5.dp))
        Text(text = slowCounter.toString())
    }
}
