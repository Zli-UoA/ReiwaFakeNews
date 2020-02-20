package com.zli.usecase.impl

import com.zli.domain.model.News
import com.zli.domain.repository.NewsRepository
import com.zli.usecase.savenews.SaveNewsResult
import com.zli.usecase.savenews.SaveNewsUseCase

class SaveNewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : SaveNewsUseCase {
    override suspend fun execute(text: String): SaveNewsResult {
        return try {
            val news = News(text)
            newsRepository.save(news)
            SaveNewsResult.Success(news)
        } catch (e: Exception) {
            SaveNewsResult.Failure(e.message ?: "unknown error")
        }
    }
}