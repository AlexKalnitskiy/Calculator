package com.example.calculator.model

import java.lang.Exception
import kotlin.math.roundToInt

class CalculatorModel {

    private var dotPrinted = false
    var currentInput = "0"
    var tempResult = "0"
    var finalResult = "0"
    var currentOperation: Operation = OperationBuilder().buildOperation(OperationType.EMPTY)

    fun setCurrentOperation(operationType: OperationType) {
        commitOperation()
        currentInput = ""
        currentOperation = OperationBuilder().buildOperation(operationType)
    }

    fun addInputSymbol(s: Char) {
        if (s == '.') addDot() else addSymbol(s)
    }

    fun removeSymbol() {
        try {
            if (currentInput.last() == '.') dotPrinted = false
            currentInput = currentInput.dropLast(1)
            if (currentInput.isEmpty()) currentInput = "0"
            performOperation()
        } catch (e: Exception) {
        }
    }

    fun repeatOperation() {
        commitOperation()
        performOperation()
    }

    fun clearAll() {
        currentOperation = OperationBuilder().buildOperation(OperationType.EMPTY)
        currentInput = "0"
        tempResult = "0"
        finalResult = "0"
    }

    private fun performOperation() {
        tempResult = try { displayAsInt(currentOperation.operation(currentInput.toDouble(), finalResult.toDouble())) }
        catch (e : Exception){ "0" }
    }

    private fun displayAsInt(result: Double): String =
        if (result.roundToInt().toDouble() == result) result.toInt().toString() else result.toString()

    private fun addSymbol(symbol: Char) {
        currentInput = if (currentInput == "0") symbol.toString() else "$currentInput$symbol"
        performOperation()
    }

    private fun addDot() {
        if (!dotPrinted) dotPrinted = true
        addSymbol('.')
    }

    private fun commitOperation() {
        finalResult = tempResult
    }
}