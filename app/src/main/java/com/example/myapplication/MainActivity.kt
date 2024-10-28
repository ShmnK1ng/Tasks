package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mixedList: List<Any?> = listOf(
            "Hello",
            3.14,
            true,
            20,
            "World",
            100L,
            5.5f,
            'A',
            null
        )

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val firstInt = mixedList.findFirstInt()
            Log.d("MainActivity", "First Int in list: ${firstInt ?: "not found"}")
        }
    }
}