package com.sukhralia

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.sukhralia.plugins.*
import com.sukhralia.routes.setupJobRoutes

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT")?.toInt()?:8089, host = "0.0.0.0") {
        configureSerialization()
        setupJobRoutes()
    }.start(wait = true)
}
