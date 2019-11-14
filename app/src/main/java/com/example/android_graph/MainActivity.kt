package com.example.android_graph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
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
        lineDataSet.setCircleColor(ContextCompat.getColor(this, R.color.white))

        repeat(8) { labels.add(it.toString()) }
        lineChart.data = LineData(labels, lineDataSet)

    }
}
