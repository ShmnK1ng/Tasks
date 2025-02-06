package com.example.core.di

import com.example.core.data.api.Api1
import com.example.core.data.api.Api2
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApiModule::class])
interface CoreComponent {
    fun api1(): Api1
    fun api2(): Api2
}