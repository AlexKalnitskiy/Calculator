package com.example.calculator.presenter

import com.example.calculator.model.OperationType

interface CalculatorPresenterInterface {
    fun onNumberInput(char: Char)
    fun onOperationInput(operation: OperationType)
    fun onResultInput()
    fun onDeleteInput()
    fun onClearInput()
    fun updateActivity()
}