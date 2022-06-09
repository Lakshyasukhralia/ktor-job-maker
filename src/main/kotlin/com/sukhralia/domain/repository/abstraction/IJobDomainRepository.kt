package com.sukhralia.domain.repository.abstraction

import com.sukhralia.domain.models.JobDomainModel
import com.sukhralia.rest.models.JobRequestModel

interface IJobDomainRepository {
    suspend fun insertDummy()
    suspend fun allJobs(): List<JobDomainModel>
    suspend fun addJob(jobRequestModel: JobRequestModel): JobDomainModel
    suspend fun updateJob(id: String, jobRequestModel: JobRequestModel): JobDomainModel?
    suspend fun deleteJob(id: String): String?
}