package com.example.composescreens.ui.theme.screens.discover

import com.example.composescreens.ui.theme.screens.utils.BaseViewModel

sealed class DiscoverUiEffect :BaseViewModel.BaseUiEffect{
    data object NavigateToPayment : DiscoverUiEffect()

}