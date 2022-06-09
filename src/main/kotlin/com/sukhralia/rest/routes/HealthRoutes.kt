package com.sukhralia.rest.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.setupHealthRoutes() {

    routing {

        get("/") {
            call.respondText { "Healthy" }
        }

    }

}