package com.zli.adapter.controller.impl

import com.zli.adapter.controller.savenews.SaveNewsController
import com.zli.adapter.json.converter.toJson
import com.zli.adapter.json.model.SaveNewsRequestJson
import com.zli.adapter.json.model.SaveNewsResultJson
import com.zli.usecase.savenews.SaveNewsUseCase

internal class SaveNewsControllerImpl(
    private val saveNewsUseCase: SaveNewsUseCase
) : SaveNewsController {
    override suspend fun execute(
        saveNewsRequestJson: SaveNewsRequestJson
    ): SaveNewsResultJson {
        return saveNewsUseCase.execute(saveNewsRequestJson.text).toJson()
    }
}