package com.phg.dicerolller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        resultText = findViewById(R.id.result_text_number)

        rollButton.text = "Let ` s Roll"
        resultText.text = "Roll the dice"

        rollButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Dice Rolled", Toast.LENGTH_SHORT).show()
            showRandomNumber()
        }
    }

    private fun showRandomNumber() {
        (Random().nextInt(6) + 1).let { randomNumber ->
            resultText.text = randomNumber.toString()
        }
    }
}