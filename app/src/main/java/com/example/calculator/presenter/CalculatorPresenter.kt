package com.example.calculator.presenter

import com.example.calculator.model.CalculatorModel
import com.example.calculator.model.OperationType
import com.example.calculator.activity.CalculatorActivityInterface
import com.example.calculator.R

class CalculatorPresenter(activity: CalculatorActivityInterface) : BasePresenter(), CalculatorPresenterInterface {

    override val calcModel: CalculatorModel = CalculatorModel()
    override val calcActivity: CalculatorActivityInterface = activity
    override val keyMap = hashMapOf(
        Pair(R.id.button_calc_0, '0'),
        Pair(R.id.button_calc_1, '1'),
        Pair(R.id.button_calc_2, '2'),
        Pair(R.id.button_calc_3, '3'),
        Pair(R.id.button_calc_4, '4'),
        Pair(R.id.button_calc_5, '5'),
        Pair(R.id.button_calc_6, '6'),
        Pair(R.id.button_calc_7, '7'),
        Pair(R.id.button_calc_8, '8'),
        Pair(R.id.button_calc_9, '9'),
        Pair(R.id.button_calc_dot, '.')
    )

    override val operationsMap = hashMapOf(
        Pair(R.id.button_calc_plus, OperationType.PLUS),
        Pair(R.id.button_calc_minus, OperationType.MINUS),
        Pair(R.id.button_calc_multiply, OperationType.MULTIPLY),
        Pair(R.id.button_calc_divide, OperationType.DIVIDE))

    override fun onNumberInput(id: Int) {
        calcModel.addInputSymbol(keyMap[id] ?: '0')
        updateActivity()
    }

    override fun onOperationInput(id: Int) {
        calcModel.setCurrentOperation(operationsMap[id]!!)
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