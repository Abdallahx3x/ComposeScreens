package com.example.composescreens.ui.theme.screens.payment

import androidx.lifecycle.viewModelScope
import com.example.composescreens.data.IComposeScreensDataStore
import com.example.composescreens.ui.theme.screens.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(private val dataStore: IComposeScreensDataStore) :
    BaseViewModel<PaymentUiState, PaymentUiEffect>(PaymentUiState()),
    PaymentInteractionListener {
    override fun onClickSubscribeButton() {
        viewModelScope.launch {
            dataStore.markPaymentSubscriptionComplete()
        }
        sendUiEffect(PaymentUiEffect.NavigateToDiscover)
    }



}
