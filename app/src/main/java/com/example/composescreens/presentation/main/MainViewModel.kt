package com.example.composescreens.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composescreens.data.IComposeScreensDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStore: IComposeScreensDataStore) :
    ViewModel() {
    private val _isFirstTimeLaunchComplete: MutableStateFlow<Boolean> by lazy { MutableStateFlow(false) }
    val isFirstTimeLaunchComplete = _isFirstTimeLaunchComplete.asStateFlow()

    init {
        viewModelScope.launch {
            if (dataStore.isFirstTimeLaunchComplete()) {
                _isFirstTimeLaunchComplete.update { true }
            }
        }
    }

}