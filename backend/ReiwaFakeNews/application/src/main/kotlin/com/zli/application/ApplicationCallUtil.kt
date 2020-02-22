package com.zli.application

import com.zli.adapter.json.model.Result
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

suspend fun ApplicationCall.respondResult(result: Result) {
    respond(
        HttpStatusCode.allStatusCodes.first { it.value == result.statusCode },
        result
    )
}