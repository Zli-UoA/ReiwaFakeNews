package com.zli.adapter.json.model

import kotlinx.serialization.Serializable

sealed class GetNewsResultJson : Result {

    @Serializable
    data class Success(val newsList: List<NewsJson>) : GetNewsResultJson() {
        override val isSuccess: Boolean = true
    }

    @Serializable
    data class Failure(val error: String) : GetNewsResultJson() {
        override val isSuccess: Boolean = false
    }
}