package com.example.composelearning.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.composables.ColourTimer

@Composable
fun RememberUpdatedStateDemo(
    modifier: Modifier = Modifier,
) {

    var buttonColour by remember { mutableStateOf("Unknown") }

    Log.d("#codelab","Composing Demo with colour : $buttonColour")
    SideEffect {
        Log.d("#codelab","Recomposition is successful")
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { buttonColour = "Red" },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {
            Text("Red Button")
        }
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { buttonColour = "Black" },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text("Black Button")
        }
        Spacer(Modifier.height(24.dp))
        Text(buttonColour)
        ColourTimer(buttonColour = buttonColour)
    }
}
