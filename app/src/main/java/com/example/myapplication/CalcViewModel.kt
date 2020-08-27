package com.example.myapplication

import androidx.lifecycle.ViewModel
import java.lang.Exception

class CalcViewModel : ViewModel() {
    companion object {
        private const val SUBTRACTION = '-'
        private const val ADDITION = '+'
        private const val MULTIPLICATION = '*'
        private const val DIVISION = '/'
    }

    var result: String = "0"
    var currentValue: String = "0"
    var currentAction: Action = Action.NONE

    fun updateCurrentValue(value: Int): String {
        if (currentValue.toInt() == 0) {
            currentValue = value.toString()
        } else {
            currentValue += value
        }
        return currentValue
    }

    fun updateAction(value: Action): String {
        if (
            currentAction != Action.RESULT &&
            currentAction != Action.NONE &&
            !((value == Action.MULTIPLICATION || value == Action.DIVISION) && result == "0")
        ) {
            calcResult()
        }
        this.currentAction = value
        if (result.toInt() == 0) {
            result = currentValue
            currentValue = "0"
        }
        return result
    }


    fun calcResult() {
        when (currentAction) {
            Action.SUBTRACTION -> result = (result.toInt() - currentValue.toInt()).toString()
            Action.ADDITION -> result = (result.toInt() + currentValue.toInt()).toString()
            Action.MULTIPLICATION -> result = (result.toInt() * currentValue.toInt()).toString()
            Action.DIVISION -> result = (result.toInt() / currentValue.toInt()).toString()
            Action.NONE -> throw Exception()
        }
        currentValue = "0"
        currentAction = Action.RESULT
    }


}