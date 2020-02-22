package com.zli.adapter.json.model

import kotlinx.serialization.Serializable

sealed class SaveNewsResultJson {

    @Serializable
    data class Success(val news: NewsJson) : SaveNewsResultJson()

    @Serializable
    data class Failure(val error: String) : SaveNewsResultJson()
}