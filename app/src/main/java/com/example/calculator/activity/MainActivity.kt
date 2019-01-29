package com.example.calculator.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator.presenter.CalculatorPresenter
import com.example.calculator.presenter.CalculatorPresenterInterface
import com.example.calculator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CalculatorActivityInterface {

    private lateinit var presenter: CalculatorPresenterInterface

    override fun setCurrentOperationText(s: String) {
        calc_operation_textView.text = s
    }

    override fun setCurrentInputText(s: String) {
        calc_input_textView.text = s
    }

    override fun setResultInputText(s: String) {
        calc_result_textView.text = s
    }

    override fun setHistoryInputText(s: String) {
        calculation_history_text_view.text = s
    }

    fun onCharInput(view: View){
        presenter.onNumberInput(view.id)
    }

    fun onOperationInput(view: View){
        presenter.onOperationInput(view.id)
    }
    fun onClearInput(view: View) {
        presenter.onClearInput()
    }
    fun onDeleteInput(view: View){
        presenter.onDeleteInput()
    }
    fun onResultInput(view: View){
        presenter.onResultInput()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CalculatorPresenter(this)
    }
}
