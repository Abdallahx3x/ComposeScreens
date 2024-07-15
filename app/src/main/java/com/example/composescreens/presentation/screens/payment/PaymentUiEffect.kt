package com.example.composescreens.ui.theme.screens.payment

import com.example.composescreens.ui.theme.screens.utils.BaseViewModel

sealed class PaymentUiEffect :BaseViewModel.BaseUiEffect{
    data object NavigateToDiscover : PaymentUiEffect()

}