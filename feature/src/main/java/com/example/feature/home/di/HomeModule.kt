package com.example.feature.home.di

import com.example.core.di.CoreComponent
import com.example.feature.home.HomeRepository
import com.example.feature.home.HomeRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    @FeatureScope
    fun provideHomeRepository(coreComponent: CoreComponent): HomeRepository {
        return HomeRepositoryImpl(coreComponent.api1(), coreComponent.api2())
    }
}