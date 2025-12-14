package com.example.koltinbasics

import android.util.Log
import okio.IOException

class CircuitBreaker(private val failurethreshold: Int = 3) {
    private var failurecount = 0
    var istripped = false

    suspend fun <T> process(block:() -> T):T{
        if(istripped){
            throw IOException("circuit is open")
        }
        return try{
            val result = block()
            reset()
            result
        }catch (e: Exception){
            recordFailure()
            throw e
        }
    }
    private fun recordFailure(){
        failurecount++
        if(failurecount >= failurethreshold){
            istripped = true
            Log.d("Circuit breaker", "record failure")
        }
    }

    private fun reset(){
        failurecount = 0
        istripped = false
    }
}