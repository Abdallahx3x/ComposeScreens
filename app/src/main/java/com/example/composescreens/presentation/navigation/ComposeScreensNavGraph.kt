package com.example.composescreens.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composescreens.ui.theme.screens.discover.discoverRoute
import com.example.composescreens.ui.theme.screens.onboarding.onboardingRoute
import com.example.composescreens.ui.theme.screens.payment.paymentRoute

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@Composable
fun ComposeScreensNavGraph(navController: NavHostController, isFirstTimeLaunchComplete:Boolean) {
    NavHost(
        navController = navController,
        startDestination =if(isFirstTimeLaunchComplete) Screens.Discover.route else Screens.Onboarding.route
    ) {
        onboardingRoute()
        discoverRoute()
        paymentRoute()
    }
}