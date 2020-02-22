package com.zli.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val text: String
) {
    val tokenizedList: List<String> = text.splitToSequence("。", ".", "\n")
        .filter { it.isNotBlank() }
        .toList()
}