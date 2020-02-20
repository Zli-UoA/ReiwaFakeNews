package com.zli.adapter.router

import com.zli.usecase.getnews.GetNewsUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.getNewsRoute(getNewsUseCase: GetNewsUseCase) {

    get("/news") { param ->
        val n = call.parameters["n"]?.toInt() ?: 3
        val result = getNewsUseCase.execute(n)
        call.respond(HttpStatusCode.OK, result)
    }
}