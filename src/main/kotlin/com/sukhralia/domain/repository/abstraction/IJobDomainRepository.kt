package com.sukhralia.domain.repository.abstraction

import com.sukhralia.domain.models.JobDomainModel
import com.sukhralia.rest.models.JobRequestModel

interface IJobDomainRepository {
    suspend fun insertDummyUseCase()
    suspend fun allJobsUseCase(): List<JobDomainModel>
    suspend fun addJobUseCase(jobRequestModel: JobRequestModel): JobDomainModel
    suspend fun updateJobUseCase(id: String, jobRequestModel: JobRequestModel): JobDomainModel?
    suspend fun deleteJobUseCase(id: String): String?
}