package com.sukhralia.feature.job.rest.routes

import com.sukhralia.feature.job.domain.models.toResponse
import com.sukhralia.feature.job.domain.repository.JobRepository
import com.sukhralia.feature.job.rest.models.JobRequest
import com.sukhralia.feature.job.rest.models.toJob
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.setupJobRoutes(jobRepository: JobRepository) {

    routing {

        route("/jobs") {

            get("/") {
                call.respond(jobRepository.allJobs().map { it.toResponse() })
            }

            post("/") {
                val jobRequest = call.receive(JobRequest::class)
                val addedJob = jobRepository.addJob(jobRequest.toJob())
                call.respond(addedJob.toResponse())
            }

            put("/{id}") {
                val id = call.parameters["id"]
                val jobRequest = call.receive(JobRequest::class)
                val updatedJob = id?.let { jobId -> jobRepository.updateJob(jobId, jobRequest.toJob()) }
                if (updatedJob != null) {
                    call.respond(updatedJob.toResponse())
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