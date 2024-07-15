package com.example.composescreens.presentation.navigation

sealed class Screens(
    var route: String,
) {
    data object Onboarding : Screens("Onboarding")
    data object Discover : Screens("Discover")
    data object Payment : Screens("Payment")
}