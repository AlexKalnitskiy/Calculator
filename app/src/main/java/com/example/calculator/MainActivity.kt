package com.example.calculator

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    var currentOperation: ((Double, Double) -> Double)? = null
    var previousResult = 0.0
    private var dotPrinted = false

    fun getOperationPlus(view: View) {
        currentOperation = { x, y -> x + y }
        commitOperation()
        calc_operation_textView.text = "+ "
    }

    fun getOperationMinus(view: View) {
        currentOperation = { x, y -> y - x }
        commitOperation()
        calc_operation_textView.text = "- "
    }

    fun getOperationMultiply(view: View) {
        currentOperation = { x, y -> x * y }
        commitOperation()
        calc_operation_textView.text = "* "
    }

    fun getOperationDivide(view: View) {
        currentOperation = { x, y -> y / x }
        commitOperation()
        calc_operation_textView.text = "/ "
    }

    fun getOperationCancel(view: View) {
        resetOperation()
        calc_input_textView.text = "0"
        calc_result_textView.text = ""
    }

    private fun resetOperation(){
        currentOperation = null
        calc_operation_textView.text = ""
    }

    @SuppressLint("SetTextI18n")
    fun getOperationResult(view: View) {
        try {
            calc_result_textView.text = "= ${calculateOperation(parseInput(), previousResult)}"
            commitOperation()
            resetOperation()
        }
        catch (e : Exception){

        }
    }

    fun printDot(view: View) {
        if (!dotPrinted) {
            printOneSymbol('.')
            dotPrinted = true
        }
    }

    @SuppressLint("SetTextI18n")
    fun inputNumber(view: View) {
        printOneSymbol(findViewById<Button>(view.id).text[0])
        calc_result_textView.text = calculateOperation(parseInput(), previousResult)
    }

    fun deleteLastChar(view: View) {
        try {
            if (calc_input_textView.text.last() == '.') dotPrinted = false
            calc_input_textView.text = calc_input_textView.text.dropLast(1)
            if (calc_input_textView.text.isBlank()) calc_input_textView.text = "0"
            calc_result_textView.text = calculateOperation(parseInput(), previousResult)
        }
        catch (e : Exception){
            calc_input_textView.text = "0"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun commitOperation() {
        try {
            dotPrinted = false
            previousResult = calc_result_textView.text.toString().toDouble()
            calculation_history_text_view.text = "${calc_operation_textView.text}${calc_input_textView.text}"
            calc_input_textView.text = ""
        } catch (e: Exception) {
            dotPrinted = false
            previousResult = 0.0
            calc_input_textView.text = ""
        }
    }

    private fun calculateOperation(x: Double, y: Double) : String {
        val result = currentOperation?.invoke(x, y) ?: x
        return if (result.roundToInt().toDouble() == result) result.roundToInt().toString()
        else result.toString()
    }

    private fun parseInput(): Double {
        return calc_input_textView.text.toString().toDouble()
    }

    @SuppressLint("SetTextI18n")
    private fun printOneSymbol(symbol: Char) {
        if (calc_input_textView.text == "0") calc_input_textView.text = "$symbol"
        else calc_input_textView.text = "${calc_input_textView.text}$symbol"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}