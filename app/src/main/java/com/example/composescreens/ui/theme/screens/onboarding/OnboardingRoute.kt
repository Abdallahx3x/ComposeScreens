package com.example.composescreens.ui.theme.screens.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private val ROUTE = "Onboarding"

fun NavController.navigateToOnboardingScreen() {
    navigate(ROUTE) {

    }
}

fun NavGraphBuilder.onboardingRoute() {
    composable(ROUTE) {
        OnboardingScreen()
    }
}