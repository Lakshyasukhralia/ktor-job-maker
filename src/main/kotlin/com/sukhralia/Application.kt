package com.sukhralia

import com.sukhralia.config.database.JobMongoDatabase
import com.sukhralia.data.repository.mongo.JobMongoRepository
import com.sukhralia.config.plugins.configureSerialization
import com.sukhralia.rest.routes.setupJobRoutes
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {

    embeddedServer(Netty, port = System.getenv("PORT")?.toInt() ?: 8072, host = "0.0.0.0") {
        configureSerialization()
        setupJobRoutes(JobMongoRepository(JobMongoDatabase().provideJobCollection()))
    }.start(wait = true)

}
