package com.sukhralia.domain.repository.implementation

import com.sukhralia.data.repository.abstraction.IJobDataRepository
import com.sukhralia.domain.mapper.toJobDomainModel
import com.sukhralia.domain.models.JobDomainModel
import com.sukhralia.domain.repository.abstraction.IJobDomainRepository
import com.sukhralia.rest.models.JobRequestModel

class JobDomainRepository(private val jobDataRepository: IJobDataRepository) : IJobDomainRepository {
    override suspend fun insertDummy() {
        jobDataRepository.insertDummy()
    }

    override suspend fun allJobs(): List<JobDomainModel> {
        return jobDataRepository.allJobs().map { it.toJobDomainModel() }
    }

    override suspend fun addJob(jobRequestModel: JobRequestModel): JobDomainModel {
        return jobDataRepository.addJob(jobRequestModel.toJobDomainModel()).toJobDomainModel()
    }

    override suspend fun updateJob(id: String, jobRequestModel: JobRequestModel): JobDomainModel? {
        return jobDataRepository.updateJob(id, jobRequestModel.toJobDomainModel())?.toJobDomainModel()
    }

    override suspend fun deleteJob(id: String): String? {
        return jobDataRepository.deleteJob(id)
    }

}