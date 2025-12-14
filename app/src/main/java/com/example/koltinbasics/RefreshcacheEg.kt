package com.example.koltinbasics

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class RefreshcacheEg {

    var cachedata = "cached data"

    suspend fun refreshNetwork(){
        delay(2000)
        cachedata = "network data"
    }

    fun getData(): Flow<String> = flow{
        refreshNetwork()
        emit(cachedata)
    }.onStart { emit(cachedata) }.catch { e-> Log.d("RefreshcacheEg", "exception ${e}") }
}