package com.sukhralia.data.models

data class JobDataModel(
    var id: String? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null,
    var dataSource: String? = null
)
