package com.sukhralia.feature.job.data.models

import com.sukhralia.feature.job.domain.models.Job
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

data class JobMongo(
    @BsonId
    var id: Id<JobMongo>? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null
)

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
