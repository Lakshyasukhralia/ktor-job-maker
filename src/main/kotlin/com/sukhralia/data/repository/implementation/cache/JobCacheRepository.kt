package com.sukhralia.data.repository.implementation.cache

import com.sukhralia.data.mapper.toJobDataModel
import com.sukhralia.data.mapper.toJobCacheModel
import com.sukhralia.data.models.JobDataModel
import com.sukhralia.data.models.JobCacheModel
import com.sukhralia.data.repository.abstraction.IJobDataRepository
import com.sukhralia.domain.models.JobDomainModel
import com.sukhralia.enums.JobCategory
import com.sukhralia.enums.JobStatus
import kotlinx.coroutines.runBlocking
import java.util.*

class JobCacheRepository : IJobDataRepository {

    private var jobCacheModels = ArrayList<JobCacheModel>()

    private fun setId(): String {
        return UUID.randomUUID().toString().substring(0, 15)
    }

    init {
        runBlocking {
            insertDummy()
        }
    }

    override suspend fun insertDummy() {
        jobCacheModels.add(
            JobCacheModel(
                id = setId(),
                title = "Food delivery",
                description = "Deliver food to office",
                categoryId = JobCategory.HOMEWORK.categoryId,
                postedBy = 1234,
                statusId = JobStatus.OPEN.statusId
            )
        )
    }

    override suspend fun allJobs(): List<JobDataModel> {
        return jobCacheModels.map { it.toJobDataModel() }
    }

    override suspend fun addJob(jobDomainModel: JobDomainModel): JobDataModel {
        val jobCacheModel = jobDomainModel.toJobDataModel().toJobCacheModel()
        jobCacheModel.apply {
            id = setId()
            statusId = JobStatus.OPEN.statusId
        }
        jobCacheModels.add(jobCacheModel)
        return jobCacheModel.toJobDataModel()
    }

    override suspend fun updateJob(id: String, jobDomainModel: JobDomainModel): JobDataModel? {
        val jobCacheModel = jobDomainModel.toJobDataModel().toJobCacheModel()
        val foundJob = jobCacheModels.find {
            it.id == id
        }
        foundJob?.apply {
            title = jobCacheModel.title
            description = jobCacheModel.description
            categoryId = jobCacheModel.categoryId
        }
        return foundJob?.toJobDataModel()
    }

    override suspend fun deleteJob(id: String): String? {
        val foundJob = jobCacheModels.find {
            it.id == id
        }
        jobCacheModels.remove(foundJob)
        return foundJob?.id
    }

}