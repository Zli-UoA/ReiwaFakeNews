package com.zli.adapter.router

import com.zli.usecase.getnews.GetNewsUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

@KtorExperimentalLocationsAPI
fun Route.getNewsRoute(getNewsUseCase: GetNewsUseCase) {

    @Location("/news")
    data class GetNewsRequest(val n: Int = 3)
    get<GetNewsRequest> { param ->
        val result = getNewsUseCase.execute(param.n)
        call.respond(HttpStatusCode.OK, result)
    }
}