package com.zli.adapter.mock

import com.zli.domain.model.News
import com.zli.domain.repository.NewsRepository

internal object MockNewsRepository : NewsRepository {

    private val newsList = arrayListOf(
        News(
            "ほげほげほげほげ。ほげほげ。ほげほげほげほげ。"
        ),
        News(
            "ほげほげほげほげ。ほげほげ。ほげほげほげほげ。"
        ),
        News(
            "ほげほげほげほげ。ほげほげ。ほげほげほげほげ。"
        )
    )

    override suspend fun findRandom(n: Int): List<News> {
        return newsList.shuffled().subList(0, n)
    }

    override suspend fun save(news: News) {
        newsList.add(news)
    }
}