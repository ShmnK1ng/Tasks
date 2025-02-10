package com.example.feature.home.di

import com.example.core.di.CoreComponent
import com.example.feature.home.presentation.HomeFragment
import com.example.feature.home.presentation.HomeViewModel
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [HomeModule::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    fun homeViewModelFactory(): HomeViewModel.Factory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): HomeComponent
    }
}