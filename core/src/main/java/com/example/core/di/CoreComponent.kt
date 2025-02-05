package com.example.core.di

import com.example.core.data.api.Api1
import com.example.core.data.api.Api2
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApiModule::class])
interface CoreComponent {
    @Named("retrofit1")fun retrofit1(): Retrofit
    @Named("retrofit2")fun retrofit2(): Retrofit

    fun api1(): Api1
    fun api2(): Api2
}