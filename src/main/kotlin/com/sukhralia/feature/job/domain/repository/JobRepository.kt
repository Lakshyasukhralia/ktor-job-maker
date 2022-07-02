package com.sukhralia.feature.job.domain.repository

import com.sukhralia.feature.job.domain.models.Job

interface JobRepository {
    suspend fun insertDummy()
    suspend fun allJobs(): List<Job>
    suspend fun addJob(job: Job): Job
    suspend fun updateJob(id: String, job: Job): Job?
    suspend fun deleteJob(id: String): String?
}