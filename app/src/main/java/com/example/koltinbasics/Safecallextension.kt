package com.example.koltinbasics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> safeCall(call:suspend () -> T): Result<T>{
    return withContext(Dispatchers.IO){
       try{
            Result.success(call())
       }catch (e: Exception){
            Result.failure(e)
       }
    }
}