package com.sukhralia.data

class JobManager {

    private var jobs = ArrayList<Job>()

    private fun setId(): Long {
        return jobs.size.toLong()
    }

    init {
        jobs.add(
            Job(
                id = setId(),
                title = "Food delivery",
                description = "Deliver food to home",
                categoryId = JobCategory.HOMEWORK.categoryId,
                postedBy = 1234,
                statusId = JobStatus.OPEN.statusId
            )
        )
    }

    fun allJobs(): ArrayList<Job> {
        return jobs
    }

    fun addJob(job: Job): Job {
        job.apply {
            id = setId()
            statusId = JobStatus.OPEN.statusId
        }
        jobs.add(job)
        return job
    }

    fun updateJob(id: Long, job: Job): Job? {
        val foundJob = jobs.find {
            it.id == id
        }

        foundJob?.apply {
            title = job.title
            description = job.description
            categoryId = job.categoryId
        }

        return foundJob
    }

    fun deleteJob(jobId: Long?): Long? {
        val foundJob = jobs.find {
            it.id == jobId
        }

        jobs.remove(foundJob)

        return jobId
    }

}