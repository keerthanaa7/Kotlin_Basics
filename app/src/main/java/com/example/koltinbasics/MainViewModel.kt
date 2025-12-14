package com.example.koltinbasics

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

class MainViewModel: ViewModel() {
    private val mutableuistateflow = MutableStateFlow<Int>(0)
    init {
        getdata()
    }

    fun getdata(){
        viewModelScope.launch {
            Log.d("MainViewModel", "current thread ${Thread.currentThread().name}")
            val result = withContext(Dispatchers.IO){
                waitondata()
            }
            printdata(result)

        }
    }

    suspend fun waitondata(): String{
        Log.d("MainViewModel", "current thread waitondata ${Thread.currentThread().name}")
        delay(1000)
        return "data success"
    }

    fun printdata(data: String){
        Log.d("MainViewModel", "data ${data}")
        Log.d("MainViewModel", "current thread printdata${Thread.currentThread().name}")
    }

     fun refreshDashboard(){
         viewModelScope.launch {
             try{
                 val data = gettotaldata()
                 Log.d("Mainviewmodel" , "data ${data}")
             }catch (e: Exception){
                 Log.d("Mainviewmodel ", "EXCEPTION ${e}")
             }
         }
    }

    suspend fun gettotaldata(): String{
        val userdeferedvalue = withContext(Dispatchers.IO){
            async {
                getuser()
            }
        }

        val somelistdefered = withContext(Dispatchers.IO){
            async {
                getlist()
            }
        }
        val user = userdeferedvalue.await()
        val list = somelistdefered.await()
        return "user ${user}  list ${list}"
    }

    suspend fun getuser(): String{
        delay(1000)
        return "john"
    }

    suspend fun getlist(): List<String>{
        delay(1000)
        return listOf("john", "beth", "himanshu")
    }

     fun timeoutexample(){
        viewModelScope.launch {
            try {
                val result1 = withTimeout(500){
                    doontime("fast")
                }
                Log.d("MainViewmodel", "success no timeout")
            }catch (e: TimeoutCancellationException){
                Log.d("Mainviewmodel" , "timeout exception")
            }

            val result2 = withTimeoutOrNull(1000){
                doontime("slow")
            }
            if(result2 == null){
                Log.d("Mainviewmodel ", "result is null")
            }
        }
    }

    suspend fun doontime(taskname: String){
        if(taskname == "fast"){
            delay(1000)
        }else{
            delay(2000)
        }
    }

    fun loaddata(){
        viewModelScope.launch {
            val result = safeCall { mocknetworcall(false) }
            result.onSuccess {
                Log.d("mAINVIEWMODEL " , " load data success")
            }
            result.onFailure {
                Log.d("mAINVIEWMODEL " , " load data failure")
            }

        }
    }

    suspend fun mocknetworcall(shouldfail: Boolean){
        if(shouldfail){
            throw IllegalArgumentException("fail")
        }else{
            delay(1000)
        }
    }
}