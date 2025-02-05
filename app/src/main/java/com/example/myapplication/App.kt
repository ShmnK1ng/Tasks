package com.example.myapplication

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent

class App: Application() {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.create()
    }
}