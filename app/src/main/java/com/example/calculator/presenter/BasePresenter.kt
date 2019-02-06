package com.example.calculator.presenter
import com.example.calculator.activity.CalculatorActivityInterface
import com.example.calculator.model.CalculatorModel

abstract class BasePresenter {
    abstract val calcModel : CalculatorModel
    abstract val calcActivity : CalculatorActivityInterface
}