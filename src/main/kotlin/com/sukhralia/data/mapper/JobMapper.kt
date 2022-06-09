package com.sukhralia.data.mapper

import com.sukhralia.data.models.Job
import com.sukhralia.data.models.JobCache
import com.sukhralia.data.models.JobMongo

fun JobMongo.toJob(): Job {
    return Job(
        id = id.toString(),
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

fun JobCache.toJob(): Job {
    return Job(
        id = id,
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