package com.example.composescreens.presentation.screens.discover

import androidx.lifecycle.viewModelScope
import com.example.composescreens.data.IComposeScreensDataStore
import com.example.composescreens.ui.theme.screens.discover.DiscoverInteractionListener
import com.example.composescreens.ui.theme.screens.discover.DiscoverUiEffect
import com.example.composescreens.ui.theme.screens.discover.DiscoverUiState
import com.example.composescreens.ui.theme.screens.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(private val dataStore: IComposeScreensDataStore) :
    BaseViewModel<DiscoverUiState, DiscoverUiEffect>(DiscoverUiState()),
    DiscoverInteractionListener {
    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch (Dispatchers.Main){
            if (dataStore.isPaymentSubscriptionComplete()) {
                _state.update { it.copy(isPaymentSubscriptionComplete = true) }
            }else{
                _state.update { it.copy(isPaymentSubscriptionComplete = false) }
            }
        }
    }

    override fun onClickAddButtonBeforePayment() {
        sendUiEffect(DiscoverUiEffect.NavigateToPayment)
    }


    override fun onChangeText(text: String) {
        _state.update { it.copy(text = text) }
    }

}