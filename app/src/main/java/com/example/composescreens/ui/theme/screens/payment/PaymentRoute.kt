package com.example.composescreens.ui.theme.screens.payment

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private val ROUTE = "Payment"

fun NavController.navigateToPaymentScreen() {
    navigate(ROUTE) {

    }
}

fun NavGraphBuilder.paymentRoute() {
    composable(ROUTE) {
        PaymentScreen()
    }
}