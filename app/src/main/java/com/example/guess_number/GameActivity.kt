package com.example.guess_number

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*

class GameActivity: AppCompatActivity() {
    var max = 0
    private var min = 0
    var halfe = 0
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()
        min = intent.getIntExtra("minimal", 0)
        max = intent.getIntExtra("maximal", 0)
        textView = findViewById(R.id.field)
        halfe = halfeDec(max, min)
        textView.text = halfe.toString()
    }

    fun answerNo(view: android.view.View) {
        if (halfe == min) {
            finishValue(max)
        }
        min = halfe
        halfe = halfeDec(max, min)
        textView.text = halfe.toString()
        Snackbar.make(view, "Try harder", Snackbar.LENGTH_SHORT).show()
    }

    fun answerYes(view: android.view.View) {
        Snackbar.make(view, "U win", Snackbar.LENGTH_SHORT).show()
///        Timer("u win", true).schedule(500) {
///            this.finish()
        }

    private fun finishValue(res: Int) {
        val resultIntent = Intent()
        val putExtra = resultIntent.putExtra("result", res)
        setResult(Activity.RESULT_OK, resultIntent)
        this.finish()
    }

    private fun halfeDec(max: Int, min: Int): Int {
        return (max + min) / 2
    }

}