package com.sukhralia.data

import kotlinx.serialization.Serializable

@Serializable
data class Job(
    var id : Long? = null,
    var title: String,
    var categoryId: Int,
    var description: String,
    var postedBy: Long? = null,
    var statusId: Int? = null
)

enum class JobStatus(val statusId: Int,val status: String){
    CLOSED(0,"Closed"),
    OPEN(1,"Open")
}

enum class JobCategory(val categoryId: Int,val categoryName: String){
    DELIVERY(0,"Delivery"),
    HOMEWORK(1,"Homework"),
    OTHER(2,"Other"),
}