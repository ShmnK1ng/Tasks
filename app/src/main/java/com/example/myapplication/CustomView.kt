package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.random.Random

class CustomView(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var progress = 0
    private val filledPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = getRandomColor()
    }
    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.LTGRAY
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()
        canvas.drawRect(0f, 0f, width, height, backgroundPaint)
        val filledWidth = (progress / 100f) * width
        canvas.drawRect(0f, 0f, filledWidth, height, filledPaint)
    }

    private fun getRandomColor(): Int {
        val random = Random(System.currentTimeMillis())
        return Color.rgb(
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )
    }

    fun incrementProgress() {
        progress += 10
        if (progress > 100) progress = 0
        filledPaint.color = getRandomColor()
        invalidate()
    }
}