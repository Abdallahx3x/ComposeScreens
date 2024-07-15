package com.example.composescreens.di

import com.example.composescreens.data.ComposeScreensDataStore
import com.example.composescreens.data.IComposeScreensDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindPreferencesDataSource(composeScreensDataStore: ComposeScreensDataStore): IComposeScreensDataStore
}