package com.example.calculator.model

class OperationBuilder {
    fun buildOperation(currentOp: OperationType): Operation {
        return when (currentOp) {
            OperationType.PLUS -> Operation("+ ") { x, y -> x + y }
            OperationType.MINUS -> Operation("- ") { x, y -> y - x }
            OperationType.MULTIPLY -> Operation("* ") { x, y -> x * y }
            OperationType.DIVIDE -> Operation("/ ") { x, y -> y / x }
            OperationType.EMPTY -> Operation("") { x, _ -> x}
        }
    }
}