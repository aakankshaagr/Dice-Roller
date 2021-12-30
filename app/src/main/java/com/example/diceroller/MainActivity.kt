package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

            //toast message
            //val toast= Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()


        }
        //writing type of parameter is important

    }

    private fun rollDice() {
        //TODO("Not yet implemented")
        val dice = Dice(numSides = 6)
        // Roll dice 1
        val diceRoll1 : Int= dice.roll()
        //Roll dice 2
        val diceRoll2 : Int= dice.roll()
        //add both dice numbers
        val addRoll : Int=diceRoll1 + diceRoll2
        //text view resource
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = addRoll.toString()
        //set dice 1 image
        val diceImageView1: ImageView =findViewById(R.id.imageView4)
        diceRollVal(diceRoll1,diceImageView1)
        //set dice 2 image
        val diceImageView2: ImageView =findViewById(R.id.imageView)
        diceRollVal(diceRoll2,diceImageView2)


    }

    private fun diceRollVal(diceVal :Int,resultImageView: ImageView){

        when(diceVal){
            1 -> resultImageView.setImageResource(R.drawable.dice_1)
            2->resultImageView.setImageResource(R.drawable.dice_2)
            3->resultImageView.setImageResource(R.drawable.dice_3)
            4->resultImageView.setImageResource(R.drawable.dice_4)
            5->resultImageView.setImageResource(R.drawable.dice_5)
            6-> resultImageView.setImageResource(R.drawable.dice_6)
        }
        resultImageView.contentDescription = diceVal.toString()
    }

}

class Dice (private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }

}

