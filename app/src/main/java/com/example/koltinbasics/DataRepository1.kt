package com.example.koltinbasics

class DataRepository1(private val apiService: ApiService,
    private val cacheService: CacheService) {

    suspend fun getData(): String{
        return try{
            val data = apiService.getData()
            cacheService.saveData(data)
            data
        }catch (e: Exception){
            cacheService.loadData()?:throw Exception("exception")
        }

    }

}