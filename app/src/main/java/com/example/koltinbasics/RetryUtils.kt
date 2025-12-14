package com.example.koltinbasics

import android.util.Log
import kotlinx.coroutines.delay
import okio.IOException

suspend fun <T> RetryUtil(times: Int = 3,
                          factor: Double = 2.0,
                          initialdelay:Long = 100,
                          block:suspend() -> T):T{
    var currentdetay = initialdelay

    repeat(times-1){attempt->
        try{
            return block()
        }catch (e: Exception){
            Log.d("RetryUtil ", "repeat ${attempt}")
        }
        delay(currentdetay)
        currentdetay = (currentdetay * factor).toLong()

    }
    return block()
}

var callcount = 0
suspend fun fetchdata(): String{
    callcount++
    if(callcount < 3){
        throw IOException("network timeout")
    }
    return "user data :{id:1, name :user}"
}