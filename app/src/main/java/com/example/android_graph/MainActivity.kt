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

//        repeat(24) { labels.add(it.toString()) }
//        lineChart.data = LineData(labels, lineDataSet)
//        구버전에서는 위 코드로 라벨을 설정할 수 있었으나, 3 이상 버전으로 업그레이드 된 이후 변경이 불가능하다. 추가적으로 알아봐야 할듯.
        lineChart.data = LineData(lineDataSet)

    }
}
