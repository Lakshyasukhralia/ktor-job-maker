package com.sukhralia.domain.mapper

import com.sukhralia.data.models.JobDataModel
import com.sukhralia.domain.models.JobDomainModel
import com.sukhralia.rest.models.JobRequestModel
import com.sukhralia.rest.models.JobResponseModel

fun JobDomainModel.toJobResponseModel(): JobResponseModel {
    return JobResponseModel(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId,
        dataSource = dataSource
    )
}


fun JobDataModel.toJobDomainModel(): JobDomainModel {
    return JobDomainModel(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId,
        dataSource = dataSource
    )
}

fun JobRequestModel.toJobDomainModel(): JobDomainModel {
    return JobDomainModel(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}