package com.example.presentation.views

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.presentation.commons.loadProgress
import kotlinx.coroutines.launch

@Composable
fun AnimatedProgress(
    modifier: Modifier = Modifier,
    initValue: Int,
) {

    SideEffect {
        Log.d("#codelab","AnimatedProgress recomposition is successful")
    }

    var currentProgress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(key1 = initValue) {
        launch {
            loadProgress(initValue) { progress ->
                Log.d("#codelab","LaunchedEffect with ${progress.toFloat()}")
                currentProgress = progress.toFloat() / 100
            }
        }
    }

    LinearProgressIndicator(
        progress = { currentProgress },
        modifier = modifier.fillMaxWidth(),
    )
}
