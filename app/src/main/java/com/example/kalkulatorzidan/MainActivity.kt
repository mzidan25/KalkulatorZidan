package com.example.kalkulatorzidan

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        radioGroup = findViewById(R.id.radioGroup)
        buttonCalculate = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1 = input1.text.toString()
        val num2 = input2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Harap masukkan kedua angka", Toast.LENGTH_SHORT).show()
            return
        }

        val number1 = num1.toDouble()
        val number2 = num2.toDouble()
        var result = 0.0
        val selectedOperation = radioGroup.checkedRadioButtonId

        if (selectedOperation == -1) {
            Toast.makeText(this, "Pilih Operasi yang Anda Inginkan", Toast.LENGTH_SHORT).show()
            return
        }

        when (selectedOperation) {
            R.id.radioAdd -> result = number1 + number2
            R.id.radioSubtract -> result = number1 - number2
            R.id.radioMultiply -> result = number1 * number2
            R.id.radioDivide -> {
                if (number2 != 0.0) {
                    result = number1 / number2
                } else {
                    Toast.makeText(this, "Tidak Bisa Membagi dengan 0", Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("result", result)
            putExtra("nim", "225150407111039")
            putExtra("nama", "Muhammad Zidan")
        }
        startActivity(intent)
    }
}
