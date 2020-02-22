package com.zli.adapter.json.converter

import com.zli.adapter.json.model.GetNewsResultJson
import com.zli.adapter.json.model.NewsJson
import com.zli.adapter.json.model.SaveNewsResultJson
import com.zli.domain.model.News
import com.zli.usecase.getnews.GetNewsResult
import com.zli.usecase.savenews.SaveNewsResult

fun News.toJson(): NewsJson = NewsJson(
    text,
    tokenizedList
)

fun GetNewsResult.toJson(): GetNewsResultJson = when (this) {
    is GetNewsResult.Success -> GetNewsResultJson.Success(newsList.map(News::toJson))
    is GetNewsResult.Failure -> GetNewsResultJson.Failure(error)
}

fun SaveNewsResult.toJson(): SaveNewsResultJson = when (this) {
    is SaveNewsResult.Success -> SaveNewsResultJson.Success(news.toJson())
    is SaveNewsResult.Failure -> SaveNewsResultJson.Failure(error)
}