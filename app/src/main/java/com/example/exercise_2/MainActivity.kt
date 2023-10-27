package com.example.exercise_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConvert = findViewById<Button>(R.id.btnCovert)
        val number = findViewById<EditText>(R.id.etNumber)
        btnConvert.setOnClickListener {
              val number = number.text.toString()
            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_NUMBER", number)
                startActivity(it)

            }
        }


    }
}