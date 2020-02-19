package com.zli.adapter.router

import com.zli.usecase.savenews.SaveNewsResult
import com.zli.usecase.savenews.SaveNewsUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.post
import io.ktor.response.respond
import io.ktor.routing.Route

@KtorExperimentalLocationsAPI
fun Route.saveNewsRoute(saveNewsUseCase: SaveNewsUseCase) {

    @Location("/news")
    data class SaveNewsRequest(val text: String)
    post<SaveNewsRequest> { param ->
        val result = saveNewsUseCase.execute(param.text)
        when (result) {
            is SaveNewsResult.Success -> call.respond(HttpStatusCode.Created, result)
            is SaveNewsResult.Failure -> call.respond(HttpStatusCode.BadRequest, result)
        }
    }
}