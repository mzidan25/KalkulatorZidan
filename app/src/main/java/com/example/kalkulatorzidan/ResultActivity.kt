package com.example.kalkulatorzidan

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textResult = findViewById(R.id.textResult)

        val result = intent.getDoubleExtra("result", 0.0)
        val nim = intent.getStringExtra("nim")
        val nama = intent.getStringExtra("nama")

        textResult.text = "Hasil: $result\nNIM: $nim\nNama: $nama"
    }
}
