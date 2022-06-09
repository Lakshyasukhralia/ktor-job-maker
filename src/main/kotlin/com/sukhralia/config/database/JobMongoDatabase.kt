package com.sukhralia.config.database

import com.sukhralia.data.models.JobMongo
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class JobMongoDatabase {

    private var database: CoroutineDatabase

    init {
        val client =
            KMongo.createClient("mongodb+srv://lakshya:haryana97@cluster0.qrm58.mongodb.net/?retryWrites=true&w=majority").coroutine
        database = client.getDatabase("job_maker")
    }

    fun provideJobCollection(): CoroutineCollection<JobMongo> = database.getCollection<JobMongo>()
}