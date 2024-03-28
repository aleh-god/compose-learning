package com.example.composelearning.data

import com.example.composelearning.domain.gates.AppRepository

object StaticDataSource : AppRepository {
    override suspend fun getData(): Result<String> = runCatching {
        "Data value"
    }
}
