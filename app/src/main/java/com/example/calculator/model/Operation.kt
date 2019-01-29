package com.example.calculator.model

data class Operation(val operationName : String, val operation : (Double, Double) -> Double)