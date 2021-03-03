package com.example.segmentedprogressbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import com.example.segmentedprogressbar.Util.SegmentedProgressBar

class MainActivity : AppCompatActivity() {

    @BindView(R.id.seg_progress)
    lateinit var seg_progress: SegmentedProgressBar
    var count = 0

    @BindView(R.id.btnBack)
    lateinit var btnBack: Button

    @BindView(R.id.btnForward)
    lateinit var btnForward: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        seg_progress.apply {
            max = 7
            step = 1
            stepDoneColor = Color.GREEN
            stepUndoneColor = Color.GRAY
        }


        btnBack.setOnClickListener {
            count--
            segmentApply(count)
        }
        btnForward.setOnClickListener {
            if (count < 7) {
                count++
                segmentApply(count)
            }
        }

    }
    private fun segmentApply(steps: Int){
        seg_progress.apply {
            max = 7
            step = steps
            stepDoneColor = Color.GREEN
            stepUndoneColor = Color.GRAY
        }
    }
}