package com.example.core.di

import com.example.core.data.api.Api1
import com.example.core.data.api.Api2
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
object ApiModule {

    @Provides
    @Singleton
    fun provideApi1(
        @Named("retrofit1") retrofit: Retrofit
    ): Api1 {
        return retrofit.create(Api1::class.java)
    }

    @Provides
    @Singleton
    fun provideApi2(
        @Named("retrofit2") retrofit: Retrofit
    ): Api2 {
        return retrofit.create(Api2::class.java)
    }
}