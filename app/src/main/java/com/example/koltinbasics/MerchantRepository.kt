package com.example.koltinbasics

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed interface ApiInterface<out T>{
    object Loading: ApiInterface<Nothing>
    data class Success<out T>(val data:T): ApiInterface<T>
    data class Error(val message: String): ApiInterface<Nothing>

}

class MerchantRepository {
    fun getMerchantData(): Flow<ApiInterface<String>> = flow {
        emit(ApiInterface.Loading)
        delay(500)
        val isSuccess = true
        if(isSuccess){
            emit(ApiInterface.Success("success"))
        }else{
            emit(ApiInterface.Error("Failure"))
        }

    }
}