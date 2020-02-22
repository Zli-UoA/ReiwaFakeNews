package com.zli.domain.model

data class News(
    val text: String
) {
    fun tokenizedList(): List<String> {
        return text.splitToSequence("。", ".", "\n")
            .filter { it.isNotBlank() }
            .toList()
    }
}