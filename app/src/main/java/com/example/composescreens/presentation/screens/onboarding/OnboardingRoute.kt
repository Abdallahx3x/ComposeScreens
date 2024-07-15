package com.example.composescreens.ui.theme.screens.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composescreens.presentation.navigation.Screens


private val ROUTE = Screens.Onboarding.route

fun NavController.navigateToOnboardingScreen() {
    navigate(ROUTE) {

    }
}

fun NavGraphBuilder.onboardingRoute() {
    composable(ROUTE) {
        OnboardingScreen()
    }
}