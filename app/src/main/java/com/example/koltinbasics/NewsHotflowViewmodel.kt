package com.example.koltinbasics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsHotflowViewmodel: ViewModel() {
    private val stateflowoutputmutable: MutableStateFlow<String> = MutableStateFlow<String>("no news")
    val newsoutput: StateFlow<String> = stateflowoutputmutable

    init {
        fetchnews()
    }
    fun fetchnews(){
        viewModelScope.launch {
            delay(200)
            stateflowoutputmutable.value = "news started"
        }

    }
}