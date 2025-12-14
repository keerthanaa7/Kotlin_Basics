package com.example.koltinbasics

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecordRepository {

    fun getRecord(): Flow<List<Record>> = flow {
        emit(listOf(Record("Record A", 1), Record("Record B", 2)))
        delay(1000)
        emit(listOf(Record("Record A", 1), Record("Record B", 2), Record("Record C", 3)))
    }
}