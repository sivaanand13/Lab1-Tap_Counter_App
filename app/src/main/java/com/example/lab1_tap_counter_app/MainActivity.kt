package com.example.lab1_tap_counter_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0
    var increment = 1
    var upgraded = false
    var currentGoal = 100;
    var goalsReached = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.counter)
        val goalView = findViewById<TextView>(R.id.currentGoal)
        val goalsReachedView = findViewById<TextView>(R.id.goalsReached)
        textView.text = counter.toString()
        val button = findViewById<ImageButton>(R.id.counterButton)
        val upgradeButton = findViewById<Button>(R.id.upgradeButton)
        upgradeButton.visibility= View.GONE
        goalView.text = "Goal: $currentGoal"
        goalsReachedView.text = "Goals Reached: $goalsReached"

        button.setOnClickListener{
            counter += increment
            textView.text = counter.toString()
            if (counter >= 100 && !upgraded) {
                upgraded = true
                upgradeButton.visibility= View.VISIBLE

            }
            if (counter >= currentGoal) {
                currentGoal *= 2
                goalsReached ++
                goalView.text = "Goal: $currentGoal"
                goalsReachedView.text = "Goal Reached: $goalsReached"
            }
        }

        upgradeButton.setOnClickListener{
            increment = 2
            upgradeButton.visibility= View.GONE
        }
    }
    /*
    *paw button img source: https://www.gamefaces.com/product/blue-paw-print-temporary-tattoo-2/
    *background img source: https://www.freepik.com/free-photos-vectors/dog-background
    * */
}