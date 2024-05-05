package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var button2: Button
    lateinit var textview: TextView
    lateinit var imageview: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find views by id and assign to properties
        button2 = findViewById(R.id.button2)
        textview = findViewById(R.id.text)
        imageview = findViewById(R.id.image)

        button2.setOnClickListener {
            // Use lambda expression for click listener
            val c = (1..6).random()
            textview.text = c.toString()
            when (c) {
                1 -> imageview.setImageResource(R.drawable.one)
                2 -> imageview.setImageResource(R.drawable.two)
                3 -> imageview.setImageResource(R.drawable.three)
                4 -> imageview.setImageResource(R.drawable.four)
                5 -> imageview.setImageResource(R.drawable.five)
                6 -> imageview.setImageResource(R.drawable.six)
            }
        }

        // WindowInsetsCompat from listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
