package com.zli.usecase.impl

import com.zli.domain.model.News
import com.zli.domain.repository.NewsRepository
import com.zli.usecase.savenews.SaveNewsResult
import com.zli.usecase.savenews.SaveNewsUseCase

internal class SaveNewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : SaveNewsUseCase {
    override suspend fun execute(text: String): SaveNewsResult {
        try {
            if (text.isBlank()) {
                return SaveNewsResult.Failure.EmptyForm()
            }
            val news = News(text)
            newsRepository.save(news)
            return SaveNewsResult.Success(news)
        } catch (e: Exception) {
            return SaveNewsResult.Failure.Unknown(e)
        }
    }
}