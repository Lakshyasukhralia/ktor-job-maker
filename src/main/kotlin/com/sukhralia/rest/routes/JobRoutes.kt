package com.sukhralia.rest.routes

import com.sukhralia.domain.mapper.toJobResponseModel
import com.sukhralia.domain.repository.abstraction.IJobDomainRepository
import com.sukhralia.rest.models.JobRequestModel
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.setupJobRoutes(jobDomainRepository: IJobDomainRepository) {

    routing {

        route("/jobs") {

            get("/") {
                call.respond(jobDomainRepository.allJobsUseCase().map { it.toJobResponseModel() })
            }

            post("/") {
                val jobRequestModel = call.receive(JobRequestModel::class)
                val addedBook = jobDomainRepository.addJobUseCase(jobRequestModel)
                call.respond(addedBook.toJobResponseModel())
            }

            put("/{id}") {
                val id = call.parameters["id"]
                val jobRequestModel = call.receive(JobRequestModel::class)
                val updatedBook = id?.let { jobId -> jobDomainRepository.updateJobUseCase(jobId, jobRequestModel) }
                if (updatedBook != null) {
                    call.respond(updatedBook.toJobResponseModel())
                }else{
                    call.respondText { "Job with id : $id not found" }
                }
            }

            delete("/{id}") {
                val id = call.parameters["id"] ?: ""
                val deletedJobId = jobDomainRepository.deleteJobUseCase(id)
                call.respondText { "Deleted job with id : $deletedJobId" }
            }
        }

    }

}