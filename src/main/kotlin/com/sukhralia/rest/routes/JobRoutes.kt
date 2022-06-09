package com.sukhralia.rest.routes

import com.sukhralia.data.repository.JobRepository
import com.sukhralia.rest.models.JobDto
import com.sukhralia.rest.models.toJob
import com.sukhralia.rest.models.toJobDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.setupJobRoutes(jobRepository: JobRepository) {

    routing {

        route("/jobs") {

            get("/") {
                call.respond(jobRepository.allJobs().map { it.toJobDto() })
            }

            post("/") {
                val jobDto = call.receive(JobDto::class)
                val addedBook = jobRepository.addJob(jobDto.toJob())
                call.respond(addedBook.toJobDto())
            }

            put("/{id}") {
                val id = call.parameters["id"]
                val jobDto = call.receive(JobDto::class)
                val updatedBook = id?.let { jobId -> jobRepository.updateJob(jobId, jobDto.toJob()) }
                if (updatedBook != null) {
                    call.respond(updatedBook.toJobDto())
                }else{
                    call.respondText { "Job with id : $id not found" }
                }
            }

            delete("/{id}") {
                val id = call.parameters["id"] ?: ""
                val deletedJobId = jobRepository.deleteJob(id)
                call.respondText { "Deleted job with id : $deletedJobId" }
            }
        }

    }

}