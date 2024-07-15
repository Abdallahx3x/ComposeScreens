package com.example.composescreens.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ComposeScreensDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : IComposeScreensDataStore {
    override suspend fun markFirstTimeLaunchComplete() {
        dataStore.edit { preferences ->
            preferences[KEY_FIRST_TIME_LAUNCH] = true
        }
    }

    override suspend fun isFirstTimeLaunchComplete(): Boolean {
        return runBlocking {
            val result =dataStore.data.map { preferences -> preferences[KEY_FIRST_TIME_LAUNCH] }.first()
            result != null
        }
    }

    override suspend fun markPaymentSubscriptionComplete() {
        dataStore.edit { preferences ->
            preferences[PAYMENT_SUBSCRIPTION] = true
        }
    }

    override suspend fun isPaymentSubscriptionComplete(): Boolean {
        return runBlocking {
            val result =dataStore.data.map { preferences -> preferences[PAYMENT_SUBSCRIPTION] }.first()
            result != null
        }
    }

    companion object {
        private val KEY_FIRST_TIME_LAUNCH = booleanPreferencesKey("first_time_launch")
        private val PAYMENT_SUBSCRIPTION = booleanPreferencesKey("payment-subscription")
    }
}