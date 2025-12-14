package com.example.koltinbasics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

sealed interface UIState{
    data object Loading: UIState
    data class Success(val data:List<String>): UIState
}

class SampleViewModel(): ViewModel() {
    val uistate_cold: Flow<UIState> = flow {
        emit(UIState.Loading)
        delay(100)
        emit(UIState.Success(listOf("apple", "banana", "guava")))
    }

    val uistate: StateFlow<UIState> = uistate_cold.stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(1000),
        initialValue = UIState.Loading)
}