package com.example.conversormoedas.api

import com.example.conversormoedas.model.FinanceResponse
import retrofit2.Call
import retrofit2.http.GET

interface FinanceApi {
    @GET("finance?key=d18b57f7")
    fun getCotacoes() : Call<FinanceResponse>
}