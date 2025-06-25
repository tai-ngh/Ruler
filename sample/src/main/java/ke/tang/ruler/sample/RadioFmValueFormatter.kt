package com.ts.radiocherryapp

import ke.tang.ruler.RulerValueFormatter
import java.util.Locale

class RadioFmValueFormatter(
    val minValue: Int,
    val maxValue: Int,
    val scaleStep: Int,
) : RulerValueFormatter {
    var valueArr: IntArray = IntArray((maxValue - minValue) / scaleStep + 1) { index ->
        minValue + scaleStep * index
    }

    override fun formatValue(value: Int): String = (getRulerValue(value)/100).toString()

    fun formatNormalValue(index: Int): String =
        String.format(Locale.getDefault(), "%.1f", getRulerValue(index)/100f)

    override fun isLongScale(index: Int): Boolean = getRulerValue(index) % 100 == 0

    override fun getRulerValue(index: Int): Int = valueArr[index]
}
