package com.zli.adapter.controller.getnews

import com.zli.adapter.json.model.GetNewsResultJson

interface GetNewsController {
    suspend fun execute(n: Int): GetNewsResultJson
}