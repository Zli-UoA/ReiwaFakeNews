package com.zli.adapter.db.converter

import com.zli.adapter.db.dao.NewsDao
import com.zli.domain.model.News

object NewsConverter {
    fun convertToDomainModel(newsDao: NewsDao): News {
        return News(
            newsDao.text
        )
    }
}