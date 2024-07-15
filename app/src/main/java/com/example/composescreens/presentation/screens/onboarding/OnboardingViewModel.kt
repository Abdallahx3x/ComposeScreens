package com.example.composescreens.ui.theme.screens.onboarding

import androidx.lifecycle.viewModelScope
import com.example.composescreens.data.IComposeScreensDataStore
import com.example.composescreens.ui.theme.screens.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val dataStore: IComposeScreensDataStore) :
    BaseViewModel<OnboardingUiState, OnboardingUiEffect>(OnboardingUiState()),
    OnboardingInteractionListener {

    override fun onClickStartButton() {
        viewModelScope.launch {
            dataStore.markFirstTimeLaunchComplete()
        }
        sendUiEffect(OnboardingUiEffect.NavigateToDiscover)
    }

}