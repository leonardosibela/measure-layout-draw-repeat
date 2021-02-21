package com.example.measurelayoutdrawrepeat

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.roundToInt

class TallyCounterView(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet),
    TallyCounter {

    private lateinit var backgroundPaint: Paint
    private lateinit var linePaint: Paint
    private lateinit var numberPaint: TextPaint
    private lateinit var backgroundRect: RectF
    private var cornerRadius: Float = 0f
    private var displayCount = "0000"

    init {
        backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        backgroundPaint.color = ContextCompat.getColor(context, R.color.color_primary)
        linePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        linePaint.color = ContextCompat.getColor(context, R.color.color_accent)
        linePaint.strokeWidth = 1f
        numberPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        numberPaint.color = ContextCompat.getColor(context, android.R.color.white)
        numberPaint.textSize = (64f * resources.displayMetrics.scaledDensity).roundToInt().toFloat()
        backgroundRect = RectF()
        cornerRadius = (2f * resources.displayMetrics.scaledDensity).roundToInt().toFloat()
        setCount(0)
    }

    // Don't allocate objects here. This might be called a lot
    override fun onDraw(canvas: Canvas) {
        // Grab canvas dimensions
        val canvasWidth = width.toFloat()
        val canvasHeight = height.toFloat()

        // Calculate center on the x axis
        val centerX = canvasWidth * 0.5

        // Setting the background values left = 0 and top = 0 right = canvasWidth and bottom = canvasHeight
        // This way the rectangle will occupy the whole canvas
        backgroundRect.set(0f, 0f, canvasWidth, canvasHeight)

        // Drawing the rectangle on the canvas using the RecF object, a cornerRadius for the x and y and a backgroundPaint
        canvas.drawRoundRect(backgroundRect, cornerRadius, cornerRadius, backgroundPaint)

        // Drawing the baseline on with the Y = the center of the canvas
        // We are using 0.6 instead of 0.5 to calculate the center because a text baseline is
        // a little bellow the center
        val baselineY = (canvasHeight * 0.6).roundToInt().toFloat()

        // Drawing the baseline on the canvas starting from 0 and finishing on the baselineY on the X axis
        // starting from the canvasWidth and finishing on the baselineY on the y axis
        // and using the linePaint
        canvas.drawLine(0f, baselineY, canvasWidth, baselineY, linePaint)

        // Draw text

        // Measure the width of the text to display using our variable displayCount
        val textWidth = numberPaint.measureText(displayCount)

        // Figure out the x-coordinate that will center the text in the canvas
        val textX = (centerX - textWidth * 0.5).roundToInt().toFloat()

        // Drawing the text on the canvas passing the x and y values and the numberPaint
        canvas.drawText(displayCount, textX, baselineY, numberPaint)
    }

    override fun reset() {
        Toast.makeText(context, "Reseting", Toast.LENGTH_LONG).show()
    }

    override fun increment() {
        Toast.makeText(context, "Incrementing", Toast.LENGTH_LONG).show()
    }

    override fun getCount(): Int {
        return 0
    }

    override fun setCount(count: Int) {
        Toast.makeText(context, "Setting count", Toast.LENGTH_LONG).show()
    }
}