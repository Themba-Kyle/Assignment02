package com.example.assignment02

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Review : AppCompatActivity() {

    private lateinit var reviewTextView: TextView
    private lateinit var exitButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        reviewTextView = findViewById(R.id.reviewTextView)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
        exitButton = findViewById(R.id.exitButton)
        val reviewText = StringBuilder()

        if (questions != null && answers != null) {
            for (i in questions.indices) {
                val answerText = if (answers[i]) "True" else "False"
                reviewText.append("Q${i + 1}: ${questions[i]}\nAnswer: $answerText\n\n")
            }
        } else {
            reviewText.append( """
            1. Nelson Mandela was the president in 1994
            Correct Answer: True

            2. Mussolini was the leader of Nazi Germany
            Correct Answer: False

            3. Mussolini had one child
            Correct Answer: False

            4. Hitler died in 1945
            Correct Answer: True

            5. World War 2 ended in 1945
            Correct Answer: True
            """.trimIndent())
        }

        reviewTextView.text = reviewText.toString()

        // Exit the app when button is clicked
        exitButton.setOnClickListener {
            finishAffinity()  // Closes the app completely.
        }

    }
}
