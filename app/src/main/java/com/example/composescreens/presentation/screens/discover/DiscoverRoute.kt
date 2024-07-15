package com.example.composescreens.ui.theme.screens.discover

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composescreens.presentation.navigation.Screens


private val ROUTE = Screens.Discover.route

fun NavController.navigateToDiscoverScreen() {
    navigate(ROUTE) {
        popBackStack()
        popBackStack()
    }
}

fun NavGraphBuilder.discoverRoute() {
    composable(ROUTE) {
        DiscoverScreen()
    }
}