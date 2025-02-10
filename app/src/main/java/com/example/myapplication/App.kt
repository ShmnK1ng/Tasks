package com.example.myapplication

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.core.di.DaggerCoreComponent

class App : Application(), CoreComponentProvider {

    private lateinit var _coreComponent: CoreComponent
    override val coreComponent: CoreComponent
        get() = _coreComponent

    override fun onCreate() {
        super.onCreate()
        _coreComponent = DaggerCoreComponent.create()
    }
}