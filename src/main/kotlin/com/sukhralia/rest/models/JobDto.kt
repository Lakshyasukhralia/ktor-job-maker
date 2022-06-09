package com.sukhralia.rest.models

import com.sukhralia.data.models.Job
import kotlinx.serialization.Serializable

@Serializable
data class JobDto(
    var id: String? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null
)

fun JobDto.toJob(): Job {
    return Job(
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}

fun Job.toJobDto(): JobDto {
    return JobDto(
        id = id.toString(),
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}