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

object CachedTimeDelegate : CachedTimeProvider, ReadOnlyProperty<Any?, CachedTimeProvider> {

    override val cachedTime: Long = System.currentTimeMillis()
    private var coroutineScope: CoroutineScope? = null

    override fun startLogging() {
        if (coroutineScope == null) {
            coroutineScope = CoroutineScope(Dispatchers.Default + Job())
            coroutineScope?.launch {
                while (isActive) {
                    Log.d("CachedTimeDelegate", "Application start time (cached): $cachedTime")
                    delay(3000)
                }
            }
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): CachedTimeProvider {
        return this
    }

    override fun cancelLogging() {
        coroutineScope?.cancel()
        coroutineScope = null
    }
}

interface CachedTimeProvider {
    val cachedTime: Long
    fun startLogging()
    fun cancelLogging()
}