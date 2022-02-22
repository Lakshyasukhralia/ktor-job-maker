package com.sukhralia.routes

import com.sukhralia.data.Job
import com.sukhralia.data.JobManager
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.setupJobRoutes() {

    val jobManager = JobManager()

    routing {
        route("/jobs") {

            get("/") {
                call.respond(jobManager.allJobs())
            }

            post("/") {
                val book = call.receive(Job::class)
                val addedBook = jobManager.addJob(book)
                call.respond(addedBook)
            }

            put("/{id}") {
                val id = call.parameters["id"]?.toLong()
                val job = call.receive(Job::class)
                val updatedBook = id?.let { jobId -> jobManager.updateJob(jobId, job) }
                if (updatedBook != null) {
                    call.respond(updatedBook)
                }
            }

            delete("/{id}") {
                val id = call.parameters["id"]?.toLong()
                val deletedJobId = jobManager.deleteJob(id)
                call.respondText { "Deleted job with id : $deletedJobId" }
            }
        }
    }
}