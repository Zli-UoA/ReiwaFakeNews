package com.zli.usecase.savenews

import com.zli.domain.model.News
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

sealed class SaveNewsResult {

    @Serializable
    data class Success(val news: News) : SaveNewsResult()

    @Serializable
    sealed class Failure(val message: String) : SaveNewsResult() {

        @Serializable
        class EmptyForm : Failure("フォームが空です")

        @Serializable
        class Unknown(
            @Transient
            private val exception: Exception? = null
        ) : Failure(exception?.message ?: "不明なエラーです")
    }
}