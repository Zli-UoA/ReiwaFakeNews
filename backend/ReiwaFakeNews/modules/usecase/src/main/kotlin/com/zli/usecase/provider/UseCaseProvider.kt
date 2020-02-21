package com.zli.usecase.provider

import com.zli.domain.repository.NewsRepository
import com.zli.usecase.getnews.GetNewsUseCase
import com.zli.usecase.impl.GetNewsUseCaseImpl
import com.zli.usecase.impl.SaveNewsUseCaseImpl
import com.zli.usecase.savenews.SaveNewsUseCase

class UseCaseProvider(private val newsRepository: NewsRepository) {
    fun provideGetNewsUseCase(): GetNewsUseCase {
        return GetNewsUseCaseImpl(newsRepository)
    }

    fun provideSaveNewsUseCase(): SaveNewsUseCase {
        return SaveNewsUseCaseImpl(newsRepository)
    }
}