package com.example.android_graph

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis.XAxisPosition.*
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lineDatas = ArrayList<Entry>()
    private var labels = ArrayList<String>()
    private lateinit var lineDataSet: LineDataSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineDatas.add(Entry(7f, 0))
        lineDatas.add(Entry(1f, 1))
        lineDatas.add(Entry(4f, 2))
        lineDatas.add(Entry(6f, 3))
        lineDatas.add(Entry(9f, 4))
        lineDatas.add(Entry(2f, 5))
        lineDatas.add(Entry(8f, 6))
        lineDatas.add(Entry(4f, 7))

        lineDataSet = LineDataSet(lineDatas, "Test 1")
        lineDataSet.color = ContextCompat.getColor(this, R.color.black)
        lineDataSet.setCircleColor(ContextCompat.getColor(this, R.color.black))
        lineDataSet.lineWidth = 2f
        lineDataSet.circleSize = 3f
        lineDataSet.valueTextSize = 10f
        lineDataSet.setValueFormatter { value, _, _, _ -> (value.toInt()).toString() }

        val xAxis = lineChart.xAxis
        xAxis.position = BOTTOM
        xAxis.textColor = Color.BLACK

        val leftYAxis = lineChart.axisLeft
        leftYAxis.textColor = Color.BLACK

        val rightYAxis = lineChart.axisRight
        rightYAxis.setDrawLabels(false)
        rightYAxis.setDrawAxisLine(false)
        rightYAxis.setDrawGridLines(false)

        repeat(8) { labels.add(it.toString()) }
        lineChart.data = LineData(labels, lineDataSet)
        lineChart.setDescription("")
        lineChart.setBackgroundColor(Color.WHITE)
        lineChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
                editText.setText(e?.`val`.toString())
                editText2.setText(e?.xIndex.toString())
            }

            override fun onNothingSelected() { }
        })

        lineChart.animateY(2000, Easing.EasingOption.EaseInCubic)
        lineChart.invalidate()
    }
}
