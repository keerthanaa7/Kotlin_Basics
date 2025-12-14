package com.example.koltinbasics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okio.IOException


sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data object Loading : Result<Nothing>
    data class Error(val message: String) : Result<Nothing>
}

enum class Strategy {
    CACHE_ONLY, NETWORK, OFFLINE_FIRST
}

class ProductRepository {
    private var localcache: String? = "local data"

    suspend fun getProduct(strategy: Strategy): Result<String> = withContext(Dispatchers.IO) {
        when (strategy) {
            Strategy.CACHE_ONLY -> localcache?.let { Result.Success(it) }
                ?: Result.Error("cache is null")

            Strategy.NETWORK -> getDataFromNetwork()
            Strategy.OFFLINE_FIRST -> localcache?.let { Result.Success(it) } ?: getDataFromNetwork()
        }
    }

    suspend fun getDataFromNetwork(
        maxretries: Int = 3,
        longdelay: Long = 1000L
    ): Result<String> {
        var currentdelay = longdelay
        repeat(maxretries){
            attempt ->
            try{
                val data = apicall()
                localcache = data
                return Result.Success(data)
            }catch (e: Exception){
                if(attempt ==maxretries-1){
                    return Result.Error("failed after all attmpts")
                }
                delay(currentdelay)
                currentdelay = 2 * currentdelay

            }
        }
        return Result.Error("failed")

    }

    suspend fun apicall(): String{
        delay(500)
        if(Math.random() < 0.7) throw IOException("slow connection")
        return "new ipad pro"
    }
}