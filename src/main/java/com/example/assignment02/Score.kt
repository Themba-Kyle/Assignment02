package com.example.assignment02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Score : AppCompatActivity() {
    private lateinit var scoreView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreView = findViewById(R.id.scoreView)

        val reviewButton = findViewById<Button>(R.id.reviewButton)

        // Get score from the previous screen
        val score = intent.getIntExtra("score" , 0)

        // Give feedback based on score
        val feedback = if (score >= 3) "Great job!" else "Keep practising!"
        scoreView.text = "$feedback Your score: $score / 5"

        reviewButton.setOnClickListener {
            val intent = Intent(this , Review::class.java)
            startActivity(intent)
            finish()
        }
    }}