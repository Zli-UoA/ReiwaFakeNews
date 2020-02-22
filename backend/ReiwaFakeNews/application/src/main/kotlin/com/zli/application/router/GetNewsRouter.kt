package com.zli.application.router

import com.zli.adapter.controller.getnews.GetNewsController
import com.zli.application.respondResult
import io.ktor.application.call
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Route

@KtorExperimentalLocationsAPI
fun Route.getNewsRoute(getNewsController: GetNewsController) {

    @Location("/news")
    data class GetNewsRequest(val n: Int = 3)
    get<GetNewsRequest> { param ->
        val result = getNewsController.execute(param.n)
        call.respondResult(result)
    }
}