package com.zli.adapter.json.model

import kotlinx.serialization.Serializable

sealed class GetNewsResultJson : Result {

    @Serializable
    data class Success(val newsList: List<NewsJson>) : GetNewsResultJson() {
        override val statusCode: Int = 200
    }

    @Serializable
    data class Failure(val error: String) : GetNewsResultJson() {
        override val statusCode: Int = 400
    }
}