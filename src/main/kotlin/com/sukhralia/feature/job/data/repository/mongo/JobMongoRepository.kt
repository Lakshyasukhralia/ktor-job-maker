package com.sukhralia.feature.job.data.repository.mongo

import com.sukhralia.config.database.JobMongoDatabase
import com.sukhralia.feature.job.data.models.JobMongo
import com.sukhralia.feature.job.data.models.toJob
import com.sukhralia.feature.job.domain.models.Job
import com.sukhralia.feature.job.domain.models.toJobMongo
import com.sukhralia.feature.job.domain.repository.JobRepository
import com.sukhralia.feature.job.enums.JobCategory
import com.sukhralia.feature.job.enums.JobStatus
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.CoroutineCollection


class JobMongoRepository(jobMongoDatabase: JobMongoDatabase) : JobRepository {

    private val jobCollection: CoroutineCollection<JobMongo> = jobMongoDatabase.provideJobCollection()

    override suspend fun insertDummy() {
        jobCollection.insertOne(
            JobMongo(
                title = "Food delivery",
                description = "Deliver food to office",
                categoryId = JobCategory.HOMEWORK.categoryId,
                postedBy = 1234,
                statusId = JobStatus.OPEN.statusId
            )
        )
    }

    override suspend fun allJobs(): List<Job> {
        val jobsMongo: List<JobMongo> = jobCollection.find().toList()
        return jobsMongo.map { it.toJob() }
    }

    override suspend fun addJob(job: Job): Job {
        val jobMongo = job.toJobMongo()
        jobMongo.apply {
            statusId = JobStatus.OPEN.statusId
        }
        jobCollection.insertOne(jobMongo)
        return jobMongo.toJob()
    }

    override suspend fun updateJob(id: String, job: Job): Job? {
        val jobMongo = job.toJobMongo()
        //Todo: Refactor to update query
        jobCollection.insertOne(jobMongo)
        return jobMongo.toJob()
    }

    override suspend fun deleteJob(id: String): String? {
        val result = jobCollection.deleteOneById(ObjectId(id))
        return if (result.deletedCount == 1L) id else null
    }

}