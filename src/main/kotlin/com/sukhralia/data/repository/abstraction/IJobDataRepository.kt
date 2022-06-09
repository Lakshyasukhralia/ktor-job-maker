package com.sukhralia.data.repository.abstraction

import com.sukhralia.data.models.JobDataModel
import com.sukhralia.domain.models.JobDomainModel

interface IJobDataRepository {
    suspend fun insertDummy()
    suspend fun allJobs(): List<JobDataModel>
    suspend fun addJob(jobDomainModel: JobDomainModel): JobDataModel
    suspend fun updateJob(id: String, jobDomainModel: JobDomainModel): JobDataModel?
    suspend fun deleteJob(id: String): String?
}