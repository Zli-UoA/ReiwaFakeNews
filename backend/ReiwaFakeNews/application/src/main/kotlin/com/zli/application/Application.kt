package com.zli.application

import com.zli.adapter.provider.controller.ControllerProvider
import com.zli.adapter.provider.repository.RepositoryProvider
import com.zli.application.router.getNewsRoute
import com.zli.application.router.saveNewsRoute
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
import kotlinx.serialization.Serializable
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

    install(StatusPages) {
        @Serializable
        data class UnknownErrorJson(val message: String, val stackTrace: String)
        exception<Throwable> { cause ->
            val errorJson = UnknownErrorJson(
                cause.message ?: "不明なエラー",
                cause.stackTrace.joinToString("\n")
            )
            cause.printStackTrace()
            call.respond(HttpStatusCode.InternalServerError, errorJson)
        }
    }

    install(Locations)

    install(CallLogging)

    install(Routing) {
        val newsRepository = RepositoryProvider.provideNewsRepository()
        val useCaseProvider = UseCaseProvider(newsRepository)
        val getNewsUseCase = useCaseProvider.provideGetNewsUseCase()
        val saveNewsUseCase = useCaseProvider.provideSaveNewsUseCase()
        val controllerProvider = ControllerProvider(getNewsUseCase, saveNewsUseCase)
        val getNewsController = controllerProvider.provideGetNewsController()
        val saveNewsController = controllerProvider.provideSaveNewsController()
        getNewsRoute(getNewsController)
        saveNewsRoute(saveNewsController)
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
}

