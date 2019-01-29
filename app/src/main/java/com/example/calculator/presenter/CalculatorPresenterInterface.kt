package com.example.calculator.presenter

interface CalculatorPresenterInterface {
    fun onNumberInput(id : Int)
    fun onOperationInput(id : Int)
    fun onResultInput()
    fun onDeleteInput()
    fun onClearInput()
}