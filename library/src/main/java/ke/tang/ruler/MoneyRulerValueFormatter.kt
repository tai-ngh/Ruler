package ke.tang.ruler

import java.text.DecimalFormat

class MoneyRulerValueFormatter(private val multiple: Int = 500, private val initialValue: Int = 0) : RulerValueFormatter {
    override fun formatValue(value: Int) = format(initialValue + value * multiple)
    override fun isLongScale(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getRulerValue(index: Int): Int {
        TODO("Not yet implemented")
    }

    companion object : DecimalFormat(",###")
}