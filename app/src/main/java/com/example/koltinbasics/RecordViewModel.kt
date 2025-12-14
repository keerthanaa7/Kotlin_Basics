package com.example.koltinbasics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class RecordViewModel(private val recordRepository: RecordRepository): ViewModel(){

    val recordflow = recordRepository.getRecord().stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(5000), initialValue = emptyList())
}