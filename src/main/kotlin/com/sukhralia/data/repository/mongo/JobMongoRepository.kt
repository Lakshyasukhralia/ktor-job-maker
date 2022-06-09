package com.sukhralia.data.repository.mongo

import com.sukhralia.data.mapper.toJob
import com.sukhralia.data.mapper.toJobMongo
import com.sukhralia.data.models.Job
import com.sukhralia.data.models.JobMongo
import com.sukhralia.data.repository.JobRepository
import com.sukhralia.enums.JobCategory
import com.sukhralia.enums.JobStatus
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.CoroutineCollection


class JobMongoRepository(private val jobCollection: CoroutineCollection<JobMongo>) : JobRepository {

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
        jobCollection.insertOne(jobMongo)
        return jobMongo.toJob()
    }

    override suspend fun updateJob(id: String, job: Job): Job? {
        val jobMongo = job.toJobMongo()
        jobCollection.insertOne(jobMongo)
        return jobMongo.toJob()
    }

    override suspend fun deleteJob(id: String): String? {
        val result = jobCollection.deleteOneById(ObjectId(id))
        return if (result.deletedCount == 1L) id else null
    }

}