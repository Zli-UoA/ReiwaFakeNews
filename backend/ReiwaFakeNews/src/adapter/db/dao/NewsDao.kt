package com.zli.adapter.db.dao

import com.zli.adapter.db.table.NewsTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class NewsDao(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<NewsDao>(NewsTable)

    var text by NewsTable.text
}