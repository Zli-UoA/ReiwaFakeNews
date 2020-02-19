package com.zli.usecase.savenews

interface SaveNewsUseCase {
    suspend fun execute(text: String): SaveNewsResult
}