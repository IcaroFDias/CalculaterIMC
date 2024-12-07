package com.comunidadedevspace.imc

import android.graphics.Color
import android.graphics.Paint.Style
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.Result.IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        var result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        var tvResult = findViewById<TextView>(R.id.tv_result)
        var tvClassificacao= findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()


        val classificacao: String = when {
            result <= 18.5f -> "Magreza"
            result in 19f..24.5f -> "Normal"
            result in 25f..29.5f -> "Sobrepeso"
            result in 30f..39.5f -> "Obesidade"
            else -> "Obesidade Grave"
        }

        val color = when (classificacao) {
            "Magreza" -> Color.BLUE
            "Normal" -> Color.GREEN
            "Sobrepeso" -> Color.YELLOW
            "Obesidade" -> Color.MAGENTA
            "Obesidade Grave" -> Color.RED
            else -> Color.BLACK
        }

// Atualiza o texto e a cor
        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(color)


    }
}