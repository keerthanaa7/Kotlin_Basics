package com.example.koltinbasics

import android.util.Log
import kotlin.math.pow
import kotlin.random.Random

object RetryStrategy {

    fun getJitterTime(attempt:Int): Long{
        val baseDelay = (2.0.pow(attempt.toDouble()) * 1000).toLong()
        val jitter = Random.nextLong(0, 500)
        return baseDelay + jitter
    }
}

var count = 0;
fun apicall(): String{
    count++;
    if(count <=2){
        throw Exception("random exception")
    }
    return "200 ok response"
}