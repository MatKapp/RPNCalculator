package com.example.mateu.reversepolishnotationcalculator

import java.util.*

/**
 * Created by mateu on 4/8/2018.
 */


class CalculatorModel(){
    var stack = Stack<Double>()
    var actualValue: String = ""

    fun appendToActualString(digit: String){
        actualValue += digit
    }

    fun dropLastCharacterFromActualString(){
        if (actualValue.isNotEmpty()){
            actualValue = actualValue.dropLast(1)

        }
    }

    fun clear() {
        stack.clear()
        actualValue = ""
    }

    fun swap() {
        if (stack.size >= 2){
            var tempVal = stack[stack.lastIndex - 1]
            stack[stack.lastIndex - 1] = stack.pop()
            stack.push(tempVal)

        }
    }

    fun drop() {
        if (stack.size >= 1){
            stack.pop()
        }
    }

}

