package com.zli.usecase.savenews

import com.zli.domain.model.News

sealed class SaveNewsResult {

    data class Success(val news: News) : SaveNewsResult()

    sealed class Failure(val message: String) : SaveNewsResult() {
        object EmptyForm : Failure("フォームが空です")
        class Unknown(exception: Exception) : Failure(exception.message ?: "不明なエラーです")
    }
}