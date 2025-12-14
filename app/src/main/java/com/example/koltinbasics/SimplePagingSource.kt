package com.example.koltinbasics

import kotlinx.coroutines.delay


data class Item(val id: Int, val name: String)

sealed class ResultState{
    data class Success(val datalist:List<Item>, val nextpageey: Int?): ResultState()
    data class Error(val message: String): ResultState()
}
class SimplePagingSource {

    val pagesize = 5
    val remotedblist = List(50){ Item(it, "Item ${it}") }

    suspend fun loadpage(pagenumber:Int): ResultState{
        delay(1000)
        val start = pagenumber * pagesize
        val end = start + pagesize
        if(start < remotedblist.size){
            val sublist = remotedblist.subList(start, end.coerceAtMost(remotedblist.size))
            var nextkey: Int? = null
            if(end < remotedblist.size){
                nextkey = pagenumber +1
            }else{
                nextkey = null
            }
            return ResultState.Success(sublist, nextkey)
        }else{
            return ResultState.Error("error")
        }

    }
}