package com.zli.application

import com.zli.adapter.db.repository.NewsRepositoryOnRDBMS
import com.zli.adapter.router.getNewsRoute
import com.zli.adapter.router.saveNewsRoute
import com.zli.usecase.provider.UseCaseProvider
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.serialization.serialization
import io.ktor.util.KtorExperimentalAPI
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
@UnstableDefault
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    DBHelper.initDB()

    install(CORS) {
        anyHost()
        method(HttpMethod.Post)
        allowSameOrigin = false
        allowNonSimpleContentTypes = true
    }

    install(ContentNegotiation) {
        serialization(json = Json.indented)
    }

    install(Locations)

    install(CallLogging)

    install(Routing) {
        val newsRepository = NewsRepositoryOnRDBMS
        val useCaseProvider = UseCaseProvider(newsRepository)
        val getNewsUseCase = useCaseProvider.provideGetNewsUseCase()
        getNewsRoute(getNewsUseCase)

        val saveNewsUseCase = useCaseProvider.provideSaveNewsUseCase()
        saveNewsRoute(saveNewsUseCase)
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
}

