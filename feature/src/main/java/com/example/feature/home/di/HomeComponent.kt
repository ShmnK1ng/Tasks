package com.example.feature.home.di

import com.example.core.di.CoreComponent
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
    fun inject()

    @Component.Builder
    interface Builder {
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): HomeComponent
    }
}