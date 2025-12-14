package com.example.koltinbasics

import android.util.Log

class CacheExpiryEg<T>(private val expireTime: Long) {
    var cacheddata:T? = null
    var lastupdated:Long = 0


    fun put(data:T){
        cacheddata = data
        lastupdated = System.currentTimeMillis()
    }

    fun getData():T?{
        val currenttime = System.currentTimeMillis()
        if(cacheddata != null && (currenttime - lastupdated) < expireTime){
            return cacheddata
        }else{
            return null
        }
    }
}