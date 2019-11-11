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
    private lateinit var lineDataSet: LineDataSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineDatas.add(Entry(1f, 2f))
        lineDatas.add(Entry(2f, 3f))
        lineDatas.add(Entry(3f, 9f))
        lineDatas.add(Entry(4f, 4f))
        lineDatas.add(Entry(5f, 1f))
        lineDatas.add(Entry(6f, 8f))
        lineDatas.add(Entry(7f, 1f))

        lineDataSet = LineDataSet(lineDatas, "Test 1")
        lineDataSet.color = ContextCompat.getColor(this, R.color.black)
        lineDataSet.setCircleColor(ContextCompat.getColor(this, R.color.white))

        lineChart.data = LineData(lineDataSet)

    }
}
