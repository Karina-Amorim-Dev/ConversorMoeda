package com.example.conversormoedas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversormoedas.model.FinanceResponse
import com.example.conversormoedas.api.ClientApi


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var cotacaoUSD: Double = 0.0
    var cotacaoEUR: Double = 0.0
    var cotacaoARS: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val moedas = listOf(
            "Dólar",
            "Euro",
            "Peso Argentino"
        )

        val spMoeda = findViewById<Spinner>(R.id.spMoeda)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            moedas
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spMoeda.adapter = adapter

        // Carrega as cotações da API
        carregarCotacoes()

        val btnConversor = findViewById<Button>(R.id.btnConversor)
        val editValor = findViewById<EditText>(R.id.editValor)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        btnConversor.setOnClickListener {

            val textoValor = editValor.text.toString()

            if (textoValor.isEmpty()) {
                editValor.error = "Digite um valor"
                return@setOnClickListener
            }

            val valor = textoValor.toDoubleOrNull()

            if (valor == null) {
                editValor.error = "Digite um valor válido"
                return@setOnClickListener
            }

            val moedaSelecionada = spMoeda.selectedItem.toString()

            val valorCotacao = when (moedaSelecionada) {

                "Dólar" -> valor * cotacaoUSD

                "Euro" -> valor * cotacaoEUR

                "Peso Argentino" -> valor * cotacaoARS

                else -> 0.0
            }

            resultado.text =
                "Valor em reais: R$ %.2f".format(valorCotacao)
        }
    }

    private fun carregarCotacoes() {

        ClientApi.api.getCotacoes().enqueue(
            object : Callback<FinanceResponse> {

                override fun onResponse(
                    call: Call<FinanceResponse?>,
                    response: Response<FinanceResponse?>
                ) {

                    val body = response.body()

                    cotacaoUSD = body?.results?.currencies?.USD?.buy ?: 0.0

                    cotacaoEUR = body?.results?.currencies?.EUR?.buy ?: 0.0

                    cotacaoARS = body?.results?.currencies?.ARS?.buy ?: 0.0
                }

                override fun onFailure(
                    call: Call<FinanceResponse?>,
                    t: Throwable
                ) {

                    Toast.makeText(
                        this@MainActivity,
                        "Erro ao carregar as cotações",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }
}