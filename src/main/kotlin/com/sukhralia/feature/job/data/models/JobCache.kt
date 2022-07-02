package com.sukhralia.feature.job.data.models

import com.sukhralia.feature.job.domain.models.Job

data class JobCache(
    var id: String? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null
)

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
