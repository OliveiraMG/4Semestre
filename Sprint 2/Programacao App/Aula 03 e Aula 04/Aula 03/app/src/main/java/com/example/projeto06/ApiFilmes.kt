package com.example.projeto06

import com.example.projeto06.Filme
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiFilmes {
    @GET("/filmes")
    fun get(): Call<List<Filme>>

    @GET("/filmes/{id}")
    fun get(@Path("id") id:Int): Call<Filme>

    @POST("/filmes")
    fun post(@Body novoFilme:Filme): Call<Filme>

    @PUT("/filmes/{id}")
    fun put(@Path("id") id:Int, @Body filmeEditado:Filme): Call<Filme>
}