package com.sukhralia.data.repository.implementation.mongo

import com.sukhralia.config.database.JobMongoDatabase
import com.sukhralia.data.mapper.toJobDataModel
import com.sukhralia.data.mapper.toJobMongoModel
import com.sukhralia.data.models.JobDataModel
import com.sukhralia.data.models.JobMongoModel
import com.sukhralia.data.repository.abstraction.IJobDataRepository
import com.sukhralia.domain.mapper.toJobDataModel
import com.sukhralia.domain.models.JobDomainModel
import com.sukhralia.enums.JobCategory
import com.sukhralia.enums.JobStatus
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.CoroutineCollection


class JobMongoRepository(mongoDatabase: JobMongoDatabase) : IJobDataRepository {

    private val jobCollection: CoroutineCollection<JobMongoModel> = mongoDatabase.provideJobCollection()

    override suspend fun insertDummy() {
        jobCollection.insertOne(
            JobMongoModel(
                title = "Food delivery",
                description = "Deliver food to office",
                categoryId = JobCategory.HOMEWORK.categoryId,
                postedBy = 1234,
                statusId = JobStatus.OPEN.statusId
            )
        )
    }

    override suspend fun allJobs(): List<JobDataModel> {
        val jobsMongo: List<JobMongoModel> = jobCollection.find().toList()
        return jobsMongo.map { it.toJobDataModel() }
    }

    override suspend fun addJob(jobDomainModel: JobDomainModel): JobDataModel {
        val jobMongoModel = jobDomainModel.toJobDataModel().toJobMongoModel()
        jobMongoModel.apply {
            statusId = JobStatus.OPEN.statusId
        }
        jobCollection.insertOne(jobMongoModel)
        return jobMongoModel.toJobDataModel()
    }

    override suspend fun updateJob(id: String, jobDomainModel: JobDomainModel): JobDataModel? {
        val jobMongoModel = jobDomainModel.toJobDataModel().toJobMongoModel()
        //Todo: Refactor to update query
        jobCollection.insertOne(jobMongoModel)
        return jobMongoModel.toJobDataModel()
    }

    override suspend fun deleteJob(id: String): String? {
        val result = jobCollection.deleteOneById(ObjectId(id))
        return if (result.deletedCount == 1L) id else null
    }

}