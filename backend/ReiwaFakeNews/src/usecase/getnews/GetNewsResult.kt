package com.zli.usecase.getnews

import com.zli.domain.model.News
import kotlinx.serialization.Serializable

sealed class GetNewsResult {

    @Serializable
    data class Success(val newsList: List<News>) : GetNewsResult()

    @Serializable
    sealed class Failure(val message: String) : GetNewsResult() {
        object TooBigGetNewsSize : Failure("指定されたニュースの数が大きすぎます")
        object NewsSizeRequirePlus : Failure("指定するニュースの数を1以上にしてください")
    }
}