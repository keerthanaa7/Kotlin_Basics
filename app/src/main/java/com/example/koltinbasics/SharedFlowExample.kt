package com.example.koltinbasics

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class SharedFlowExample: ViewModel() {
    private val coldflowdata: Flow<String> = flow {
        Log.d("SharedFlowExample", "fetching data from disk")
        emit("Record A")
        delay(500)
        emit("Record B")
    }

    val sharedflowdata= coldflowdata.shareIn(viewModelScope, started = SharingStarted.WhileSubscribed(1000), replay = 1)

}