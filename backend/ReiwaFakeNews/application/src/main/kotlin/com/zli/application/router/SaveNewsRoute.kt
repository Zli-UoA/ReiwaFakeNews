package com.zli.application.router

import com.zli.adapter.controller.savenews.SaveNewsController
import com.zli.adapter.json.model.SaveNewsRequestJson
import com.zli.application.respondResult
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.saveNewsRoute(saveNewsController: SaveNewsController) {

    post("/news") {
        val request = call.receive<SaveNewsRequestJson>()
        val result = saveNewsController.execute(request)
        call.respondResult(result)
    }
}