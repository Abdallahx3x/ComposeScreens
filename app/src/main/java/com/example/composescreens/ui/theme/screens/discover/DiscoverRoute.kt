package com.example.composescreens.ui.theme.screens.discover

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private val ROUTE = "Discover"

fun NavController.navigateToDiscoverScreen() {
    navigate(ROUTE) {

    }
}

fun NavGraphBuilder.discoverRoute() {
    composable(ROUTE) {
        DiscoverScreen()
    }
}