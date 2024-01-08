package com.example.composeintro

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composeintro.ui.theme.GreetingState

class GreetingViewModel: ViewModel() {
    private val _state = mutableStateOf(GreetingState())
    val state: State<GreetingState> = _state

    fun setMessage(fine: Boolean){
        _state.value = when(fine){
            true -> _state.value.copy(message = "Good, Your Fine.")
            false -> _state.value.copy(message = "Hope, you feel better soon.")
        }
    }
}