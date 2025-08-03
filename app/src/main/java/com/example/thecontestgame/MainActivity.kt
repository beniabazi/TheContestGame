package com.example.thecontestgame

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Restore score on rotation
        score = savedInstanceState?.getInt("SCORE") ?: 0

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val btnRed = findViewById<Button>(R.id.buttonRed)
        val btnBlue = findViewById<Button>(R.id.buttonBlue)
        val btnGreen = findViewById<Button>(R.id.buttonGreen)
        val btnReset = findViewById<Button>(R.id.buttonReset)

        // Set initial score text using localisation
        scoreText.text = getString(R.string.score_label, score)

        // Media players
        val clickSound = MediaPlayer.create(this, R.raw.click_sound)
        val winSound = MediaPlayer.create(this, R.raw.win_sound)

        // Red Button Click
        btnRed.setOnClickListener {
            score += 5
            scoreText.text = getString(R.string.score_label, score)
            clickSound.start()
            Log.d("Game", "Red clicked. Score = $score")
            if (score >= 15) winSound.start()
        }

        // Blue Button Click
        btnBlue.setOnClickListener {
            score += 3
            scoreText.text = getString(R.string.score_label, score)
            clickSound.start()
            Log.d("Game", "Blue clicked. Score = $score")
            if (score >= 15) winSound.start()
        }

        // Green Button Click
        btnGreen.setOnClickListener {
            score += 2
            scoreText.text = getString(R.string.score_label, score)
            clickSound.start()
            Log.d("Game", "Green clicked. Score = $score")
            if (score >= 15) winSound.start()
        }

        // Reset Button Click
        btnReset.setOnClickListener {
            score = 0
            scoreText.text = getString(R.string.score_label, score)
            Log.d("Game", "Score reset.")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("SCORE", score)
        super.onSaveInstanceState(outState)
    }
}
