package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val SUBTRACTION = '-'
        private const val ADDITION = '+'
        private const val MULTIPLICATION = '*'
        private const val DIVISION = '/'
    }

    private val model: CalcViewModel by lazy { ViewModelProvider(this).get(CalcViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultField.text = model.result
        operationField.text = model.currentValue
        listOf<Button>(
            button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9
        ).forEachIndexed { index, button ->
            button.setOnClickListener { model.updateCurrentValue(index); updateValues() }
        }

        buttonAdd.setOnClickListener {
            model.updateAction(Action.ADDITION)
            updateValues()
        }
        buttonSub.setOnClickListener {
            model.updateAction(Action.SUBTRACTION)
            updateValues()
        }
        buttonDiv.setOnClickListener {
            model.updateAction(Action.DIVISION)
            updateValues()
        }
        buttonMult.setOnClickListener {
            model.updateAction(Action.MULTIPLICATION)
            updateValues()
        }
        buttonResult.setOnClickListener {
            model.calcResult()
            updateValues()
        }

    }

    fun updateValues() {
        operationField.text = model.currentValue
        resultField.text = model.result
    }
}