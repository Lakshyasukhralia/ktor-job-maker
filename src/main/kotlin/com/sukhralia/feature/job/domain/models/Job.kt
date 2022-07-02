package com.sukhralia.feature.job.domain.models

import com.sukhralia.feature.job.data.models.JobCache
import com.sukhralia.feature.job.data.models.JobMongo
import com.sukhralia.feature.job.rest.models.JobResponse

data class Job(
    var id: String? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null,
    var dataSource: String? = null
)

fun Job.toResponse(): JobResponse {
    return JobResponse(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}

fun Job.toJobMongo(): JobMongo {
    return JobMongo(
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}

fun Job.toJobCache(): JobCache {
    return JobCache(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}