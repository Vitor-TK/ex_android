package com.example.ex_tabuada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var num1:TextView
    lateinit var num2:TextView
    lateinit var input: EditText
    lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1txt)
        num2 = findViewById(R.id.num2txt)
        num1.text = Random.nextInt(1,9).toString()
        num2.text = Random.nextInt(1,9).toString()

    }

    fun scoreUpdate(scoreCode:Int) {

        ratingBar = findViewById(R.id.ratingBar)

        if (scoreCode == 1) {

            if (ratingBar.rating < 5) {
                ratingBar.rating = ratingBar.rating + 1

            }else{

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Parabéns você venceu!")
                builder.setMessage("Recomençando o jogo...")
                builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
                builder.show()
                ratingBar.rating = 0F

            }

        }else{

            if (ratingBar.rating > 0) {

                ratingBar.rating = ratingBar.rating - 1

            }
        }

    }

    fun iniciar(view: View) {

        input = findViewById(R.id.input)
        num1 = findViewById(R.id.num1txt)
        num2 = findViewById(R.id.num2txt)

        var result = num1.text.toString().toInt() * num2.text.toString().toInt()

        if (input.text.toString() != "") {

            if (result == input.text.toString().toInt()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Resultado")
                builder.setMessage("Acertou!")
                builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
                builder.show()
                num1.text = Random.nextInt(1, 9).toString()
                num2.text = Random.nextInt(1, 9).toString()
                scoreUpdate(1)

            } else {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Resultado")
                builder.setMessage("Errou Meu!")
                builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
                builder.show()
                num1.text = Random.nextInt(1, 9).toString()
                num2.text = Random.nextInt(1, 9).toString()
                scoreUpdate(0)

            }

            input.text.clear()

        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Resultado")
            builder.setMessage("Tem que colocar algum número! Chuta!")
            builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
            builder.show()
        }
    }



}