package com.zli.adapter.json.model

import kotlinx.serialization.Serializable

sealed class SaveNewsResultJson : Result {

    @Serializable
    data class Success(val news: NewsJson) : SaveNewsResultJson() {
        override val isSuccess: Boolean = true
    }

    @Serializable
    data class Failure(val error: String) : SaveNewsResultJson() {
        override val isSuccess: Boolean = false
    }
}