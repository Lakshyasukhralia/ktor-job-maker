package com.sukhralia.data.mapper

import com.sukhralia.data.models.JobDataModel
import com.sukhralia.data.models.JobCacheModel
import com.sukhralia.data.models.JobMongoModel
import com.sukhralia.domain.models.JobDomainModel

fun JobMongoModel.toJobDataModel(): JobDataModel {
    return JobDataModel(
        id = id.toString(),
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId,
        dataSource = dataSource
    )
}

fun JobDataModel.toJobMongoModel(): JobMongoModel {
    return JobMongoModel(
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId,
        dataSource = dataSource
    )
}

fun JobCacheModel.toJobDataModel(): JobDataModel {
    return JobDataModel(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId,
        dataSource = dataSource
    )
}

fun JobDataModel.toJobCacheModel(): JobCacheModel {
    return JobCacheModel(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId,
        dataSource = dataSource
    )
}

fun JobDomainModel.toJobDataModel(): JobDataModel {
    return JobDataModel(
        id = id,
        title = title,
        categoryId = categoryId,
        description = description,
        postedBy = postedBy,
        statusId = statusId
    )
}