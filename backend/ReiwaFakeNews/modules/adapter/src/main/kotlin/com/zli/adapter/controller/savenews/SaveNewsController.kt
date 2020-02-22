package com.zli.adapter.controller.savenews

import com.zli.adapter.json.model.SaveNewsRequestJson
import com.zli.adapter.json.model.SaveNewsResultJson

interface SaveNewsController {
    suspend fun execute(
        saveNewsRequestJson: SaveNewsRequestJson
    ): SaveNewsResultJson
}