package com.example.composelearning.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SnapshotFlowDemo(
    modifier: Modifier = Modifier,
) {

    Log.d("#codelab", "SnapshotFlowDemo: start")
    SideEffect {
        Log.d("#codelab", "SnapshotFlowDemo: Recomposition is successful")
    }

    var counter by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = counter.toString())
        if (counter % 2 == 0) {
            Box(
                modifier
                    .size(50.dp)
                    .background(color = Color.Green)
                    .clip(shape = CircleShape)
                    .border(2.dp, Color.Cyan, CircleShape)
            )
            Button(
                onClick = { counter++ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text("Click")
            }
        }
    }
}
