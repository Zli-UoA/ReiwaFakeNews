package com.zli.domain.repository

import com.zli.domain.model.News

interface NewsRepository {
    suspend fun findRandom(n: Int): List<News>

    suspend fun save(news: News)
}