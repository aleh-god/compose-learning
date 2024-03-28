package com.example.composelearning.domain.gates

interface AppRepository {

    suspend fun getData(): Result<String>
}
