package com.zli.adapter.db.table

import org.jetbrains.exposed.dao.id.UUIDTable

object NewsTable : UUIDTable() {
    val text = text("text")
}