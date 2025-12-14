package com.example.koltinbasics

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun getNumbersFlow(): Flow<Int> = flow{
    Log.d("GetNumberscoldflow", "Cold flow started");
    for(i in 1..3){
        emit(i)
        delay(100)
    }

}