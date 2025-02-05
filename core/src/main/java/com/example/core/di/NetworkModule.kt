package com.example.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    @Named("retrofit1")
    fun provideRetrofit1(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://first-api.example.com/")
            .build()
    }

    @Provides
    @Singleton
    @Named("retrofit2")
    fun provideRetrofit2(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://second-api.example.com/")
            .build()
    }
}