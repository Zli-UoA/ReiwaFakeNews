package com.zli.application

import com.typesafe.config.ConfigFactory
import io.ktor.config.HoconApplicationConfig
import io.ktor.util.KtorExperimentalAPI

@KtorExperimentalAPI
object AppConfig {
    private val config = HoconApplicationConfig(ConfigFactory.load())
    val dbDriver = config.property("ktor.db.driver").getString()
    val dbUrl = config.property("ktor.db.jdbcUrl").getString()
    val dbUser = config.property("ktor.db.dbUser").getString()
    val dbPassword = config.property("ktor.db.dbPassword").getString()
}