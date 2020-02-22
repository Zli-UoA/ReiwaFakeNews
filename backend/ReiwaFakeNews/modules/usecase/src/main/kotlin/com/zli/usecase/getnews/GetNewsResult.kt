package com.zli.usecase.getnews

import com.zli.domain.model.News
import java.lang.Exception

sealed class GetNewsResult {

    data class Success(val newsList: List<News>) : GetNewsResult()

    sealed class Failure(val error: String) : GetNewsResult() {
        object TooBigGetNewsSize : Failure("指定されたニュースの数が大きすぎます")
        object NewsSizeRequirePlus : Failure("指定するニュースの数を1以上にしてください")
        class Unknown(exception: Exception) : Failure(exception.message ?: "不明なエラーです")
    }
}