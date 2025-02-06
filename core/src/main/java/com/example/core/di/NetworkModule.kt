package com.example.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object NetworkModule {

    @Retrofit1
    @Provides
    @Singleton
    fun provideRetrofit1(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://first-api.example.com/")
            .build()
    }

    @Retrofit2
    @Provides
    @Singleton
    fun provideRetrofit2(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://second-api.example.com/")
            .build()
    }
}