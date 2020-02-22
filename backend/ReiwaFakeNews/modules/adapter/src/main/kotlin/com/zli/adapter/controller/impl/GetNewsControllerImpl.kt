package com.zli.adapter.controller.impl

import com.zli.adapter.controller.getnews.GetNewsController
import com.zli.adapter.json.converter.toJson
import com.zli.adapter.json.model.GetNewsResultJson
import com.zli.usecase.getnews.GetNewsUseCase

internal class GetNewsControllerImpl(
    private val getNewsUseCase: GetNewsUseCase
) : GetNewsController {
    override suspend fun execute(n: Int): GetNewsResultJson {
        return getNewsUseCase.execute(n).toJson()
    }
}