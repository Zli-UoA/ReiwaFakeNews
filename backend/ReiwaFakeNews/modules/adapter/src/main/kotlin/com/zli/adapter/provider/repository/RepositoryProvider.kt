package com.zli.adapter.provider.repository

import com.zli.adapter.db.repository.NewsRepositoryOnRDBMS
import com.zli.domain.repository.NewsRepository

object RepositoryProvider {
    fun provideNewsRepository(): NewsRepository = NewsRepositoryOnRDBMS
}