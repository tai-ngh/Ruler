package ke.tang.ruler.sample

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.ts.radiocherryapp.RadioFmValueFormatter
import ke.tang.ruler.OnRulerValueChangeListener
import ke.tang.ruler.sample.databinding.ActivityRulerBinding

class RulerActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityRulerBinding
//    private val radioAppManager: RadioAppManager by lazy {
//        RadioAppManager.getInstance(this)
//    }

    private lateinit var radioFmValueFormatter: RadioFmValueFormatter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

//        val amScopes = intArrayOf(531, 1629, 9)
//        binding.radioRuler.apply {
//            val radioAmValueFormatter = RadioAmValueFormatter(amScopes[0], amScopes[1], amScopes[2])
//            rulerValueFormatter = radioAmValueFormatter
//            minValue = 0
//            maxValue = radioAmValueFormatter.valueArr.size - 1
//
//            sectionScaleCount = 10
//            textTopPadding = resources.getDimensionPixelSize(R.dimen.ruler_text_top_padding)
//            bottomLinePadding = resources.getDimensionPixelSize(R.dimen.ruler_bot_line_padding)
//        }

        val fmScopes = intArrayOf(8750, 10800, 10)
        binding.radioRuler.apply {
            radioFmValueFormatter= RadioFmValueFormatter(fmScopes[0], fmScopes[1], fmScopes[2])
            rulerValueFormatter = radioFmValueFormatter
            minValue = 0
            maxValue = radioFmValueFormatter.valueArr.size - 1

            sectionScaleCount = 10
            textTopPadding = resources.getDimensionPixelSize(R.dimen.ruler_text_top_padding)
            bottomLinePadding = resources.getDimensionPixelSize(R.dimen.ruler_bot_line_padding)


        }

        binding.apply {
            radioRuler.onRulerValueChangeListener = object : OnRulerValueChangeListener {
                override fun onRulerValueChanged(value: Int, displayValue: String) {
                    tvRadioValue.text = radioFmValueFormatter.formatNormalValue(value)
                }
            }
        }
    }
}