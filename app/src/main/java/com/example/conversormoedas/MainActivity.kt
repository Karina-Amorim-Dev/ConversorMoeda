package com.example.conversormoedas

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversormoedas.api.ClientApi
import com.example.conversormoedas.model.FinanceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.btnConversor)
        button.setOnClickListener {
            ClientApi.api.getCotacoes().enqueue(object : Callback<FinanceResponse> {
                override fun onResponse(
                    p0: Call<FinanceResponse?>,
                    response: Response<FinanceResponse>
                ) {
                    println(response?.body().toString())
                }

                override fun onFailure(
                    p0: Call<FinanceResponse?>,
                    p1: Throwable
                ) {
                    TODO("Not yet implemented")
                }
            }


            )
        }
    }


}