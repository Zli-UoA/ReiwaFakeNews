package com.zli.usecase.impl

import com.zli.domain.repository.NewsRepository
import com.zli.usecase.getnews.GetNewsResult
import com.zli.usecase.getnews.GetNewsUseCase

internal class GetNewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : GetNewsUseCase {

    override suspend fun execute(n: Int): GetNewsResult {
        if (n <= 0) return GetNewsResult.Failure.NewsSizeRequirePlus()
        return try {
            val newsList = newsRepository.findRandom(n)
            GetNewsResult.Success(newsList)
        } catch (e: IndexOutOfBoundsException) {
            GetNewsResult.Failure.TooBigGetNewsSize()
        }
    }
}