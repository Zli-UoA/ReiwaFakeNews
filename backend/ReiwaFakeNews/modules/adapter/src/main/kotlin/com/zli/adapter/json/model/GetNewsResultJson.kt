package com.zli.adapter.json.model

import kotlinx.serialization.Serializable

sealed class GetNewsResultJson {

    @Serializable
    data class Success(val newsList: List<NewsJson>) : GetNewsResultJson()

    @Serializable
    data class Failure(val error: String) : GetNewsResultJson()
}