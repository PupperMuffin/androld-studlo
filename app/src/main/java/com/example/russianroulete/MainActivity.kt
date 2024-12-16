package com.example.russianroulete

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var playButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge display (use system screen space)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.textView) // Finds the result TextView
        playButton = findViewById(R.id.button) // Finds the play Button

        // Button click listener for the "Play" button
        playButton.setOnClickListener {
            if (playButton.text == "Play") {
                playGame() // Start the game if the button says "Play"
            } else {
                resetGame() // Reset the game if it's over
            }
        }

        // Connect the system window insets to handle system bars (e.g., status and navigation bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Apply the insets (padding) to the layout
        }
    }

    // Logic for the "Russian Roulette" game
    private fun playGame() {
        val isShot = Random.nextBoolean() // Random shot (50% chance)

        if (isShot) {
            resultTextView.text = "Shot! Game over." // Game over message
        } else {
            resultTextView.text = "No bullet, you're lucky!" // Lucky message
        }

        // Change button text to allow the player to restart the game
        playButton.text = "Play Again"
    }

    // Reset the game state
    private fun resetGame() {
        // Restore initial state
        resultTextView.text = "Press the button to play!"
        playButton.text = "Play"
    }
}
