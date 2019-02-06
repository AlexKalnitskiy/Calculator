package com.example.calculator.activity

import com.example.calculator.R

fun CalculatorActivityInterface.getKeyMap(): HashMap<Int, Char> {
    return hashMapOf(
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
}