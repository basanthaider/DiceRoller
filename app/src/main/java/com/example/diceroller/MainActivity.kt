package com.example.diceroller

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val scale = resources.displayMetrics.density
            val desiredPx = (16 * scale + 0.5f).toInt()
            v.setPadding(
                systemBars.left + desiredPx,
                systemBars.top + desiredPx,
                systemBars.right + desiredPx,
                systemBars.bottom + desiredPx
            )
            insets
        }
        val dice1: ImageView = findViewById(R.id.dice1_iv)
        val dice2: ImageView = findViewById(R.id.dice2_iv)
        val btn: MaterialButton = findViewById(R.id.btn)
        val diceSum :TextView = findViewById(R.id.sum_tx)


        btn.setOnClickListener {
            val randomNo1 = (1..6).random()
            val randomNo2 = (1..6).random()
            dice1.setImageResource(getDiceResources(randomNo1))
            dice2.setImageResource(getDiceResources(randomNo2))
            val sum = randomNo1+ randomNo2
            diceSum.text ="Sum:$sum"
            if (randomNo1==randomNo2)
                Toast.makeText(this, "Awsome!", Toast.LENGTH_SHORT).show()

        }


    }

    private fun getDiceResources(number: Int): Int {
        return when(number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> throw IllegalArgumentException("invalid dice number")
        }

    }
}
