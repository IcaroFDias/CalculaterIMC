package com.comunidadedevspace.imc

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


        var classificacao: String = if (result <= 18.5f ){
            "Magreza"
        } else if (result >=19f && result <=24.5f ){
            "Normal"
        } else if (result >=25f && result <= 29.5f  ){
            "Sobrepeso"
        } else if (result >= 30f && result <= 39.5f){
            "Obesidade"
        } else {
            "Obesidade Grave"
        }
        tvClassificacao.text = classificacao


    }
}