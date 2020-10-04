package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var number = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            number++
            displayNumber(number)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("name", number)
        val count: TextView = findViewById(R.id.number)
        outState.putString("number", count.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt("name")
        val text = savedInstanceState.getString("text")
        val count:TextView = findViewById(R.id.number)
        count.text = text
        displayNumber(number)
    }

    private fun displayNumber(number: Int) {
        val count:TextView = findViewById(R.id.number)
        count.text = (String.format("%04d", number))
    }
}
