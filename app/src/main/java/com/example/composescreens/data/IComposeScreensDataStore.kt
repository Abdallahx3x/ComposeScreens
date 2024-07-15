package com.example.composescreens.data

interface IComposeScreensDataStore {
    suspend fun markFirstTimeLaunchComplete()
    suspend fun isFirstTimeLaunchComplete(): Boolean
    suspend fun markPaymentSubscriptionComplete()
    suspend fun isPaymentSubscriptionComplete(): Boolean
}