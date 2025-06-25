package com.ts.radiocherryapp

import ke.tang.ruler.RulerValueFormatter

class RadioAmValueFormatter(
    val minValue: Int,
    val maxValue: Int,
    val scaleStep: Int,
): RulerValueFormatter {
    var valueArr: IntArray = IntArray((maxValue-minValue)/scaleStep + 1) { index ->
        minValue + scaleStep*index
    }

    override fun formatValue(value: Int): String = getRulerValue(value).toString()

    override fun isLongScale(index: Int): Boolean = getRulerValue(index) % 10 == 0

    override fun getRulerValue(index: Int): Int = valueArr[index]
}