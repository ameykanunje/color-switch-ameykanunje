package com.example.color_shade

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.TextView

@SuppressLint("AppCompatCustomView")
class Border(context: Context, attrs: AttributeSet) : TextView(context, attrs) {
    private val rectPaint: Paint = Paint()

    init {
        rectPaint.style = Paint.Style.STROKE
        rectPaint.color = Color.BLACK
        rectPaint.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val cornerRadius = 40f
        val rect = RectF(0f, 0f, width.toFloat(), height.toFloat())
        canvas?.drawRoundRect(rect, cornerRadius, cornerRadius, rectPaint)

    }
}