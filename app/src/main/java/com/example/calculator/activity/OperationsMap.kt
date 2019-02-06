package com.example.calculator.activity

import com.example.calculator.R
import com.example.calculator.model.OperationType

val OperationsMap = hashMapOf(
    Pair(R.id.button_calc_plus, OperationType.PLUS),
    Pair(R.id.button_calc_minus, OperationType.MINUS),
    Pair(R.id.button_calc_multiply, OperationType.MULTIPLY),
    Pair(R.id.button_calc_divide, OperationType.DIVIDE)
)