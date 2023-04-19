package com.example.manor_f12023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.manor_f12023.team.TeamActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val button = findViewById<Button>(R.id.button)
//        button.setOnClickListener {
//            val intent = Intent(this, ScheduleActivity::class.java)
//            startActivity(intent)
//        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }

//        val button3 = findViewById<Button>(R.id.button3)
//        button3.setOnClickListener {
//            val intent = Intent(this, DriverActivity::class.java)
//            startActivity(intent)
//        }

    }




}