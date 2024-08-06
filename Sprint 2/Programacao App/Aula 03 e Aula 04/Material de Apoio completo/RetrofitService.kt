package com.example.navegacao

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    const val BASE_URL_USUARIOS = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/sptech-api/"

    const val BASE_URL_FILMES = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/"

    fun getApiUsuariosService(): ApiUsuarios {
        val cliente =
            Retrofit.Builder()
                .baseUrl(BASE_URL_USUARIOS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiUsuarios::class.java)

        return cliente
    }

    fun getApiFilmesService(): ApiFilme {
        val cliente =
            Retrofit.Builder()
                .baseUrl(BASE_URL_FILMES)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiFilme::class.java)

        return cliente
    }

}