package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar componente Edittext
            //Criar variavel e associar(=) o componente UI<Edittext>
        // Recuperar bota da tela
        // Colocar acao no bota com setOnClickListener
        // Recuperar texto digitado em edtPeso

        var edtPeso = findViewById<TextInputEditText>(R.id.edtpeso)
        var edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        var btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener{

            var pesoStr: String = edtPeso.text.toString()
            var alturaStr: String = edtAltura.text.toString()
        if (pesoStr == "" || alturaStr == "") {
            //Mostrar mensagem para o usuario
            Snackbar.make(
                edtPeso,
               "Preencha todos os campos",
                Snackbar.LENGTH_LONG
            ).show()
        } else{
            var peso = pesoStr.toFloat()
            var altura = alturaStr.toFloat()
            var alturaQ2 = altura * altura

            var result = peso/alturaQ2

            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra (name:"123", result)
            startActivity(intent)



            println("Icaro pesa " + peso + " e mede " + altura + ", seu IMC é: " + result)
            }
        }


    }
}