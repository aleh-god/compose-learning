package com.example.composelearning.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composelearning.domain.gates.AppRepository
import com.example.composelearning.ui.utils.loadRemoteData

@Composable
fun ProduceStateDemo(
    provideRepository: () -> AppRepository,
    modifier: Modifier = Modifier,
) {
    Log.d("#codelab","ProduceStateDemo: start")

    SideEffect {
        Log.d("#codelab","ProduceStateDemo: Recomposition is successful")
    }

    val rateState by loadRemoteData(
        provideRepository = provideRepository
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = rateState,
        )
    }
}
