package com.example.myapplication

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object CachedTimeDelegate : ReadOnlyProperty<Any?, Long> {

    private var cachedTime: Long = System.currentTimeMillis()
    private val coroutineScope = CoroutineScope(Dispatchers.Default + Job())

    init {
        coroutineScope.launch {
            while (isActive) {
                Log.d("CachedTimeDelegate", "Application start time (cached): $cachedTime")
                delay(3000)
            }
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return cachedTime
    }

    fun cancelLogging() {
        coroutineScope.cancel()
    }
}