package com.zli.adapter.json.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsJson(
    val text: String,
    val tokenizedList: List<String>
)