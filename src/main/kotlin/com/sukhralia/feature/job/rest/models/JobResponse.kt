package com.sukhralia.feature.job.rest.models

import kotlinx.serialization.Serializable

@Serializable
data class JobResponse(
    var id: String? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null
)
