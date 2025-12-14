package com.example.koltinbasics

class CacheService {
    var cachedata: String = "last cached 2 hours ago"
    fun saveData(data: String){
        cachedata = data
    }
    fun loadData(): String{
        return cachedata
    }
}