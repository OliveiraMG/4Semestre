package com.example.projeto06

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val BASE_URL = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/sptech-api/"

    fun getApiFilmesService(): ApiFilmes {
        val cliente = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiFilmes::class.java)

        return cliente
    }
}