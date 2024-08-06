package com.example.navegacao

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiFilme {
    
    @GET("/filmes")
    fun get(): Call<List<Filme>>
    // Call do retrofit2...

    @GET("/filmes/{id}")
    fun get(@Path("id") id:Int): Call<Filme>

    @POST("/filmes")
    fun post(@Body novoFilme:Filme): Call<Filme>

    @PUT("/filmes/{id}")
    fun put(@Path("id") id:Int, @Body filmeEditado:Filme): Call<Filme>

    @DELETE("/filmes/{id}")
    fun delete(@Path("id") id:Int): Call<Void>
}