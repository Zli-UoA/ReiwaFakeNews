package com.zli.adapter.db.repository

import com.zli.adapter.db.converter.NewsConverter
import com.zli.adapter.db.dao.NewsDao
import com.zli.domain.model.News
import com.zli.domain.repository.NewsRepository
import org.jetbrains.exposed.sql.transactions.transaction

internal object NewsRepositoryOnRDBMS : NewsRepository {
    override suspend fun findRandom(n: Int): List<News> {
        return transaction {
            NewsDao.all()
                .toList()
                .shuffled()
                .subList(0, n)
                .map { NewsConverter.convertToDomainModel(it) }
        }
    }

    override suspend fun save(news: News) {
        transaction {
            NewsDao.new {
                text = news.text
            }
        }
    }
}