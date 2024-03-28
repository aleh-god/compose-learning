package com.example.composelearning.ui.utils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import com.example.composelearning.domain.gates.AppRepository
import kotlinx.coroutines.async

@Composable
fun loadRemoteData(
    provideRepository: () -> AppRepository,
): State<String> {
    return produceState(initialValue = "Init state") {

        val data = async { provideRepository().getData() }
        val loadingResult = data.await()

        value = loadingResult.fold(
            onSuccess = {
                Log.d("#codelab", "loadingResult: $it")
                it
            },
            onFailure = {
                Log.d("#codelab", "loadingResult: ${it.message}")
                it.message ?: "Empty error message"
            }
        )
    }
}
