package com.jeff.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var fiveCentImageView : ImageView
    private lateinit var tenCentImageView: ImageView
    private lateinit var quarterImageView: ImageView
    private  lateinit var dollarImageView: ImageView
    private lateinit var cashTextView: TextView
    private var cash = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fiveCentImageView = findViewById(R.id.five_cent_imageView)
        tenCentImageView = findViewById(R.id.ten_cent_imageView)
        quarterImageView = findViewById(R.id.quarter_cent_imageView)
        dollarImageView = findViewById(R.id.dollar_imageView)
        cashTextView = findViewById(R.id.cash_textView)

        fiveCentImageView.setOnClickListener{
            cash += 0.05
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }

        tenCentImageView.setOnClickListener{
            cash += 0.10
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }

        quarterImageView.setOnClickListener{
            cash += 0.25
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }

        dollarImageView.setOnClickListener{
            cash += 1.00
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }
    }
}