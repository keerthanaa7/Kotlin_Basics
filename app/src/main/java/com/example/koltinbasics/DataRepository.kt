package com.example.koltinbasics

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class DataRepository {
    private var cachedata = "Cache data"

    private fun fetchNetworkData(): Flow<String> = flow{
        delay(2000)
        var data = "Network data"
        cachedata = data

        emit(cachedata)
    }

     var data: Flow<String> = fetchNetworkData().onStart {
        emit(cachedata)
    }.catch { e -> Log.d("Data Repository", " ${e}") }

}