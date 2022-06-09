package com.sukhralia.data.models

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
