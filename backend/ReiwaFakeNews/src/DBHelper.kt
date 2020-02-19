package com.zli

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import com.zli.adapter.db.table.NewsTable
import io.ktor.util.KtorExperimentalAPI
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

@KtorExperimentalAPI
object DBHelper {

    fun initDB() {
        Database.connect(dataSource())
        SchemaUtils.create(NewsTable)
    }

    private fun dataSource(): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = AppConfig.dbDriver
            jdbcUrl = AppConfig.dbUrl
            username = AppConfig.dbUser
            password = AppConfig.dbPassword
        }
        return HikariDataSource(config)
    }
}