package com.example.calculator.presenter
import com.example.calculator.model.CalculatorModel
import com.example.calculator.model.OperationType
import com.example.calculator.activity.CalculatorActivityInterface

abstract class BasePresenter {
    abstract val operationsMap : HashMap<Int, OperationType>
    abstract val keyMap : HashMap<Int, Char>
    abstract val calcModel : CalculatorModel
    abstract val calcActivity : CalculatorActivityInterface
    abstract fun updateActivity()
}