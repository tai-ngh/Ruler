package com.ts.radiocherryapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.Shader
import android.util.AttributeSet
import android.widget.FrameLayout

class AlphaGradientLayout(
    private val context: Context,
    private val attributeSet: AttributeSet?
): FrameLayout(context, attributeSet) {

    private val FADE_COLORS: IntArray = intArrayOf(0x00D8D8D8, Color.BLACK, 0x00D8D8D8)
    private val gradientRect: Rect = Rect()
    private val gradientPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    override fun dispatchDraw(canvas: Canvas) {
        if (visibility == GONE || width == 0 || height == 0) {
            super.dispatchDraw(canvas)
            return
        }

        val l = paddingLeft
        val t = paddingTop
        val r = width - paddingRight
        val b = height - paddingBottom
        val linearGradient = LinearGradient(
            l.toFloat(), t.toFloat(), r.toFloat(), t.toFloat(),
            FADE_COLORS,
            null,
            Shader.TileMode.CLAMP
        )
        gradientRect.set(l, t, r, b)
        gradientPaint.setShader(linearGradient)

        val count = canvas.saveLayer(0.0f, 0.0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        super.dispatchDraw(canvas)
        canvas.drawRect(gradientRect, gradientPaint)
        canvas.restoreToCount(count)
    }
}