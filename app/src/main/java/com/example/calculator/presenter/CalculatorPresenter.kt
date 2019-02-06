package com.example.calculator.presenter

import com.example.calculator.activity.CalculatorActivityInterface
import com.example.calculator.model.CalculatorModel
import com.example.calculator.model.OperationType

class CalculatorPresenter(
    override val calcActivity: CalculatorActivityInterface,
    override val calcModel: CalculatorModel
) : BasePresenter(), CalculatorPresenterInterface {

    override fun onNumberInput(char: Char) {
        calcModel.addInputSymbol(char)
        updateActivity()
    }

    override fun onOperationInput(operation: OperationType) {
        calcModel.setCurrentOperation(operation)
        updateActivity()
    }

    override fun onResultInput() {
        calcModel.repeatOperation()
        updateActivity()
    }

    override fun onDeleteInput() {
        calcModel.removeSymbol()
        updateActivity()
    }

    override fun onClearInput() {
        calcModel.clearAll()
        updateActivity()
    }

    override fun updateActivity() {
        calcActivity.setCurrentInputText(calcModel.currentInput)
        calcActivity.setHistoryInputText(calcModel.finalResult)
        calcActivity.setCurrentOperationText(calcModel.currentOperation.operationName)
        calcActivity.setResultInputText(calcModel.tempResult)
    }
}