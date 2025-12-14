package com.example.koltinbasics

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.random.nextInt

fun processdataforRetryWhen(): Flow<String> = flow{

    emit("initial data loading")
    if(Random.nextDouble() < 0.7){
        throw Exception("exception ")
    }
}