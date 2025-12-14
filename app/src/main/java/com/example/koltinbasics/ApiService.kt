package com.example.koltinbasics

import okio.IOException

class ApiService {
    suspend fun getData(): String=
         throw IOException("io exception")
}