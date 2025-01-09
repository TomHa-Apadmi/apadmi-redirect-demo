package com.apadmi.tomrh.redirectdemo.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow();

    fun incrementCounter() {
        _state.value += 1
    }
}