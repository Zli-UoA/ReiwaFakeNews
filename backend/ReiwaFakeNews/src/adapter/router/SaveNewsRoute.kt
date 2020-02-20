package com.zli.adapter.router

import com.zli.usecase.savenews.SaveNewsResult
import com.zli.usecase.savenews.SaveNewsUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import kotlinx.serialization.Serializable

fun Route.saveNewsRoute(saveNewsUseCase: SaveNewsUseCase) {

    @Serializable
    data class SaveNewsRequest(val text: String)
    post("/news") {
        val request = call.receive<SaveNewsRequest>()
        val result = saveNewsUseCase.execute(request.text)
        when (result) {
            is SaveNewsResult.Success -> call.respond(HttpStatusCode.Created, result)
            is SaveNewsResult.Failure -> call.respond(HttpStatusCode.BadRequest, result)
        }
    }
}