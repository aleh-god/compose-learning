package com.example.presentation.commons

import kotlinx.coroutines.delay

suspend fun loadProgress(
    initValue: Int = 0,
    updateProgress: (Int) -> Unit
) {
    for (tick in initValue..100) {
        delay(100)
        updateProgress(tick)
    }
}