package com.example.koltinbasics

import androidx.core.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext


sealed class ResultUIState<out T> {
    object Loading : ResultUIState<Nothing>()
    data class Success<out T>(val data: T) : ResultUIState<T>()
    data class Error(val message: String) : ResultUIState<Nothing>()
}

class ThreadSafeProductRepo {

    @Volatile
    private var localcache: String? = null
    private var mutex: Mutex = Mutex()

    suspend fun getData(forceRefresh: Boolean): ResultUIState<String> = withContext(Dispatchers.IO){
        mutex.withLock {
            if(!forceRefresh && localcache != null){
                return@withLock ResultUIState.Success(localcache!!)
            }
            val resultdata = getDataFromNetwork()
            if(resultdata is ResultUIState.Success){
                localcache = resultdata.data
            }
            return@withLock resultdata
        }
    }

    suspend fun getDataFromNetwork(): ResultUIState<String> {
        delay(1000)
        return ResultUIState.Success("data from network")
    }
}