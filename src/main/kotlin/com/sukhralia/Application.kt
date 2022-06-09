package com.sukhralia

import com.sukhralia.config.database.JobMongoDatabase
import com.sukhralia.data.repository.implementation.mongo.JobMongoRepository
import com.sukhralia.config.plugins.configureSerialization
import com.sukhralia.domain.repository.implementation.JobDomainRepository
import com.sukhralia.rest.routes.setupHealthRoutes
import com.sukhralia.rest.routes.setupJobRoutes
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {

    embeddedServer(Netty, port = System.getenv("PORT")?.toInt() ?: 8072, host = "0.0.0.0") {

        val jobMongoRepository = JobMongoRepository(JobMongoDatabase())
        val jobDomainRepository = JobDomainRepository(jobMongoRepository)

        configureSerialization()
        setupHealthRoutes()
        setupJobRoutes(jobDomainRepository)

    }.start(wait = true)

}
