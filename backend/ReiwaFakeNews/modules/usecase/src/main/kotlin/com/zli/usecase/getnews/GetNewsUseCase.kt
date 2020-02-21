package com.zli.usecase.getnews

interface GetNewsUseCase {
    suspend fun execute(n: Int = 3): GetNewsResult
}