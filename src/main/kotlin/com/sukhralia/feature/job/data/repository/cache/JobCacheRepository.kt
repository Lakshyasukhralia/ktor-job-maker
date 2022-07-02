package com.sukhralia.feature.job.data.repository.cache

import com.sukhralia.feature.job.data.models.JobCache
import com.sukhralia.feature.job.data.models.toJob
import com.sukhralia.feature.job.domain.models.Job
import com.sukhralia.feature.job.domain.models.toJobCache
import com.sukhralia.feature.job.domain.repository.JobRepository
import com.sukhralia.feature.job.enums.JobCategory
import com.sukhralia.feature.job.enums.JobStatus
import kotlinx.coroutines.runBlocking
import java.util.*

class JobCacheRepository : JobRepository {

    private var jobCaches = ArrayList<JobCache>()

    private fun setId(): String {
        return UUID.randomUUID().toString().substring(0, 15)
    }

    init {
        runBlocking {
            insertDummy()
        }
    }

    override suspend fun insertDummy() {
        jobCaches.add(
            JobCache(
                id = setId(),
                title = "Food delivery",
                description = "Deliver food to office",
                categoryId = JobCategory.HOMEWORK.categoryId,
                postedBy = 1234,
                statusId = JobStatus.OPEN.statusId
            )
        )
    }

    override suspend fun allJobs(): List<Job> {
        return jobCaches.map { it.toJob() }
    }

    override suspend fun addJob(job: Job): Job {
        val jobCache = job.toJobCache()
        jobCache.apply {
            id = setId()
            statusId = JobStatus.OPEN.statusId
        }
        jobCaches.add(jobCache)
        return jobCache.toJob()
    }

    override suspend fun updateJob(id: String, job: Job): Job? {
        val jobCache = job.toJobCache()
        val foundJob = jobCaches.find {
            it.id == id
        }
        foundJob?.apply {
            title = jobCache.title
            description = jobCache.description
            categoryId = jobCache.categoryId
        }
        return foundJob?.toJob()
    }

    override suspend fun deleteJob(id: String): String? {
        val foundJob = jobCaches.find {
            it.id == id
        }
        jobCaches.remove(foundJob)
        return foundJob?.id
    }

}