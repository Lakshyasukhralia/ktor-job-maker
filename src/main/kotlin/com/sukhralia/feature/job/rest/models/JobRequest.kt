package com.sukhralia.feature.job.rest.models

import com.sukhralia.feature.job.domain.models.Job
import kotlinx.serialization.Serializable

@Serializable
data class JobRequest(
    var id: String? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null
)

fun JobRequest.toJob(): Job {
    return Job(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}