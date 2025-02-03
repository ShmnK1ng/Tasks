package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val PROGRESS_COMPLETED = "Загрузка завершена!"

class BackgroundService : Service() {

    companion object {
        val _flow = MutableStateFlow(0)
        val flow = _flow.asStateFlow()
    }

    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceScope.launch {
            var i = 0
            while (i < 100) {
                i += 10
                _flow.value = i
                delay(1000)
            }
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    applicationContext,
                    PROGRESS_COMPLETED,
                    Toast.LENGTH_SHORT
                ).show()
                stopSelf()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        serviceJob.cancel()
        super.onDestroy()
    }
}