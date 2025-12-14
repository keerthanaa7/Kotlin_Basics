package com.example.koltinbasics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import java.net.SocketTimeoutException

sealed class ResourceUIState<out T> {
    object Loading: ResourceUIState<Nothing>()
    data class Success<T>(val data:T): ResourceUIState<T>()
    data class Error(val message: String): ResourceUIState<Nothing>()
}


suspend fun <T>safecall(apical:suspend () -> T):   ResourceUIState<T>{
    return withContext(Dispatchers.IO){
        try {
            ResourceUIState.Success(apical())
        }catch (throwable: Throwable){
            when(throwable){
                is SocketTimeoutException -> ResourceUIState.Error("socket timeout exception")
                is IOException ->  ResourceUIState.Error("IO exception")
                else-> ResourceUIState.Error("general exception")
            }

        }
    }
}

suspend fun fetchprofile(): String{
    return "user profile"
}