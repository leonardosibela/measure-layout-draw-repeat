package com.example.measurelayoutdrawrepeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var countButton: Button
    private lateinit var resetButton: Button
    private lateinit var tallyCounter: TallyCounter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countButton = findViewById(R.id.count)
        resetButton = findViewById(R.id.reset)
        tallyCounter = findViewById<TallyCounterView>(R.id.tally_counter)

        countButton.setOnClickListener { count() }
        resetButton.setOnClickListener { reset() }
    }

    private fun count() {
        tallyCounter.increment()
    }

    private fun reset() {
        tallyCounter.reset()
    }
}