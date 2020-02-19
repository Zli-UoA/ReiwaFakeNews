package com.zli.usecase.savenews

import com.zli.domain.model.News
import kotlinx.serialization.Serializable

sealed class SaveNewsResult {

    @Serializable
    data class Success(val news: News) : SaveNewsResult()

    @Serializable
    data class Failure(val message: String) : SaveNewsResult()
}