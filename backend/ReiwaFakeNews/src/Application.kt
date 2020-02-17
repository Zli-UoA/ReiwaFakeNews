package com.zli

import com.zli.adapter.domain.impl.MockNewsRepository
import com.zli.adapter.router.getNewsRoute
import com.zli.usecase.impl.GetNewsUseCaseImpl
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.serialization.serialization
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@UnstableDefault
@KtorExperimentalLocationsAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(CORS) {
        allowSameOrigin = false
        anyHost()
    }

    install(ContentNegotiation) {
        serialization(json = Json.indented)
    }

    install(Locations)

    install(Routing) {
        val getNewsUseCase = GetNewsUseCaseImpl(MockNewsRepository)
        getNewsRoute(getNewsUseCase)
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
}

