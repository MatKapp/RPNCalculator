package com.example.mateu.reversepolishnotationcalculator

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {

    private var CalculatorModel = CalculatorModel()
    private var precision = 2
    val REQUEST_CODE = 10000

    fun refreshScreen(){
        thirdStackLevel.text = ""
        if (CalculatorModel.stack.size >= 3){
            thirdStackLevel.text = String.format("%.${precision}f" ,CalculatorModel.stack[CalculatorModel.stack.lastIndex-2])
        }
        secondStackLevel.text = ""
        if (CalculatorModel.stack.size >= 2){
            secondStackLevel.text = String.format("%.${precision}f" ,CalculatorModel.stack[CalculatorModel.stack.lastIndex-1])
        }
        firstStackLevel.text = ""
        if (CalculatorModel.stack.size >= 1){
            firstStackLevel.text = String.format("%.${precision}f" ,CalculatorModel.stack[CalculatorModel.stack.lastIndex-0])
        }
        if (validateStringValue(CalculatorModel.actualValue)){
            actualValue.text = String.format("%.${precision}f" ,CalculatorModel.actualValue.toDouble())
        }
        else{
            actualValue.text = ""
        }
    }

    fun validateStringValue(text : String): Boolean{
        return (!text.isBlank() && !text.isNullOrEmpty())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if ((requestCode == REQUEST_CODE)
                && (resultCode == Activity.RESULT_OK)){
            if  (data !=null){
                if (data.hasExtra("precision")){
                    precision = data.extras.getInt("precision")
                }
            }
        }
        refreshScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zeroButton.setOnClickListener{
            CalculatorModel.appendToActualString(zeroButton.text.toString())
            refreshScreen()
        }

        oneButton.setOnClickListener{
            CalculatorModel.appendToActualString(oneButton.text.toString())
            refreshScreen()
        }

        twoButton.setOnClickListener{
            CalculatorModel.appendToActualString(twoButton.text.toString())
            refreshScreen()
        }

        threeButton.setOnClickListener{
            CalculatorModel.appendToActualString(threeButton.text.toString())
            refreshScreen()
        }

        fourButton.setOnClickListener{
            CalculatorModel.appendToActualString(fourButton.text.toString())
            refreshScreen()
        }

        fiveButton.setOnClickListener{
            CalculatorModel.appendToActualString(fiveButton.text.toString())
            refreshScreen()
        }

        sixButton.setOnClickListener{
            CalculatorModel.appendToActualString(sixButton.text.toString())
            refreshScreen()
        }

        sevenButton.setOnClickListener{
            CalculatorModel.appendToActualString(sevenButton.text.toString())
            refreshScreen()
        }

        eightButton.setOnClickListener{
            CalculatorModel.appendToActualString(eightButton.text.toString())
            refreshScreen()
        }

        nineButton.setOnClickListener{
            CalculatorModel.appendToActualString(nineButton.text.toString())
            refreshScreen()
        }

        changeSignButton.setOnClickListener{
            if (validateStringValue(CalculatorModel.actualValue)){
                CalculatorModel.actualValue = (-1*CalculatorModel.actualValue.toDouble()).toString()
                refreshScreen()
            }
        }

        enterButton.setOnClickListener {
            if (validateStringValue(CalculatorModel.actualValue)){
                CalculatorModel.stack.push(CalculatorModel.actualValue.toDouble())
                CalculatorModel.actualValue = ""
            }
            else{
                if (CalculatorModel.stack.size >= 1){
                    CalculatorModel.stack.push(CalculatorModel.stack[CalculatorModel.stack.lastIndex])
                }
            }
            refreshScreen()
        }

        plusButton.setOnClickListener {
            if (validateStringValue(CalculatorModel.actualValue) && CalculatorModel.stack.size >= 1) {
                CalculatorModel.actualValue = ((CalculatorModel.actualValue).toDouble().plus(CalculatorModel.stack.pop())).toString()// += CalculatorModel.stack.pop()
            }
            refreshScreen()
        }

        minusButton.setOnClickListener {
            if (validateStringValue(CalculatorModel.actualValue) && CalculatorModel.stack.size >= 1) {
                CalculatorModel.actualValue = ((CalculatorModel.actualValue).toDouble().minus(CalculatorModel.stack.pop())).toString()// += CalculatorModel.stack.pop()
            }
            refreshScreen()
        }

        multiplyButton.setOnClickListener {
            if (validateStringValue(CalculatorModel.actualValue) && CalculatorModel.stack.size >= 1) {
                CalculatorModel.actualValue = ((CalculatorModel.actualValue).toDouble().times(CalculatorModel.stack.pop()).toString())// += CalculatorModel.stack.pop()
            }
            refreshScreen()
        }

        divideButton.setOnClickListener {
            if (validateStringValue(CalculatorModel.actualValue) && CalculatorModel.stack.size >= 1) {
                CalculatorModel.actualValue = ((CalculatorModel.actualValue).toDouble().div(CalculatorModel.stack.pop())).toString()// += CalculatorModel.stack.pop()
            }
            refreshScreen()
        }

        powButton.setOnClickListener{
            if (validateStringValue(CalculatorModel.actualValue) && CalculatorModel.stack.size >= 1) {
                CalculatorModel.actualValue = pow((CalculatorModel.actualValue).toDouble(),(CalculatorModel.stack.pop())).toString()// += CalculatorModel.stack.pop()
            }
            refreshScreen()
        }

        rootButton.setOnClickListener {
            if (validateStringValue(CalculatorModel.actualValue)) {
                CalculatorModel.actualValue = sqrt((CalculatorModel.actualValue).toDouble()).toString()// += CalculatorModel.stack.pop()
            }
            refreshScreen()
        }

        clearButton.setOnClickListener {
            CalculatorModel.dropLastCharacterFromActualString()
            refreshScreen()
        }

        clearAllButton.setOnClickListener {
            CalculatorModel.clear()
            refreshScreen()
        }

        swapButton.setOnClickListener {
            CalculatorModel.swap()
            refreshScreen()
        }

        dropButton.setOnClickListener {
            CalculatorModel.drop()
            refreshScreen()
        }

        settingsButton.setOnClickListener {
            showActivity()
        }

    }

    private fun showActivity() {
        val i = Intent(this, settingsActivity::class.java)
        startActivityForResult(i, REQUEST_CODE)
    }
}
