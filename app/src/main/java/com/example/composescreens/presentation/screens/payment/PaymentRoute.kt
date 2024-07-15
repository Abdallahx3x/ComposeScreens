package com.example.composescreens.ui.theme.screens.payment

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composescreens.presentation.navigation.Screens


private val ROUTE = Screens.Payment.route

fun NavController.navigateToPaymentScreen() {
    navigate(ROUTE) {

    }
}

fun NavGraphBuilder.paymentRoute() {
    composable(ROUTE) {
        PaymentScreen()
    }
}