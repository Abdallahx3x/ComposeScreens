package com.example.composescreens.ui.theme.screens.onboarding

import com.example.composescreens.ui.theme.screens.utils.BaseViewModel

sealed class OnboardingUiEffect : BaseViewModel.BaseUiEffect {
    data object NavigateToDiscover : OnboardingUiEffect()
}