package com.example.mateu.reversepolishnotationcalculator

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*

class settingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    override fun finish(){
        val data = Intent()
        if (!precisionInput.text.isBlank() && !precisionInput.text.isNullOrEmpty()){
            data.putExtra("precision", precisionInput.text.toString().toInt())
        }
        else{
            data.putExtra("precision", 2)
        }
        setResult(Activity.RESULT_OK, data)
        super.finish()
    }
}
