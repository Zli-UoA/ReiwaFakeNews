package com.zli.usecase.getnews

import com.zli.domain.model.News
import kotlinx.serialization.Serializable

sealed class GetNewsResult {

    @Serializable
    data class Success(val newsList: List<News>) : GetNewsResult()

    @Serializable
    sealed class Failure(val error: String) : GetNewsResult() {

        @Serializable
        class TooBigGetNewsSize : Failure("指定されたニュースの数が大きすぎます")

        @Serializable
        class NewsSizeRequirePlus : Failure("指定するニュースの数を1以上にしてください")
    }
}