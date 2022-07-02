package com.sukhralia

import com.sukhralia.config.database.JobMongoDatabase
import com.sukhralia.config.plugins.configureSerialization
import com.sukhralia.feature.job.data.repository.cache.JobCacheRepository
import com.sukhralia.feature.job.data.repository.mongo.JobMongoRepository
import com.sukhralia.feature.app.rest.setupHealthRoutes
import com.sukhralia.feature.job.rest.routes.setupJobRoutes
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {

    embeddedServer(Netty, port = System.getenv("PORT")?.toInt() ?: 8072, host = "0.0.0.0") {

        val jobMongoRepository = JobMongoRepository(JobMongoDatabase())
        val jobCacheRepository = JobCacheRepository()

        configureSerialization()
        setupHealthRoutes()
        setupJobRoutes(jobMongoRepository)

    }.start(wait = true)

}
