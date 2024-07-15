package com.example.composescreens.ui.theme.screens.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE, UiEffect>(initialState: STATE) : ViewModel() {
    interface BaseUiEffect

    protected val _state: MutableStateFlow<STATE> by lazy { MutableStateFlow(initialState) }
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<UiEffect>()
    val effect = _effect.asSharedFlow()


    protected fun sendUiEffect(effect: UiEffect) {
        viewModelScope.launch { _effect.emit(effect) }
    }

}