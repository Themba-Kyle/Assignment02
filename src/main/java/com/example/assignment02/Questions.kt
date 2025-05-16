package com.example.assignment02

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Questions : AppCompatActivity() {

    private lateinit var questionView: TextView
    private lateinit var feedView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var ReviewScoreButton: Button
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "Mussolini was the leader of Nazi Germany",
        "Mussolini had one child",
        "Hitler died in 1945",
        "World war 2 ended in 1945"
    )
    private val answers = arrayOf(true, false, false, true, true)

    private var index = 0
    private var score = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionView = findViewById(R.id.questionsView)
        feedView = findViewById(R.id.feedView)
        ReviewScoreButton = findViewById(R.id.ReviewScoreButton)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        loadQuestion()

        ReviewScoreButton.setOnClickListener {
            val intent = Intent(this, Score::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++
            if (index < questions.size) {
                loadQuestion()
                feedView.text = "Feedback"  // Reset feedback
            } else {

            }
        }
    }

    private fun loadQuestion() {
        questionView.text = questions[index]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedView.text = "Correct!"
            score++
        } else {
            feedView.text = "Incorrect!"
        }
    }
}




