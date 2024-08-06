package sptech.projeto08c

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiFilme {
    /*
    Para que possamos usar o Retrofit com Coroutines:
    1 - As funções de mapeamento dos EndPoints devem ser "suspend"
    2 - O retorno das funções deve ser Response<???>
     */
    @GET("/filmes")
    suspend fun get(): Response<List<Filme>>
    // Call do retrofit2...

    @GET("/filmes/{id}")
    suspend fun get(@Path("id") id:Int): Response<Filme>

    @POST("/filmes")
    suspend fun post(@Body novoFilme:Filme): Response<Filme>

    @PUT("/filmes/{id}")
    suspend fun put(@Path("id") id:Int, @Body filmeEditado:Filme): Response<Filme>

    @DELETE("/filmes/{id}")
    suspend fun delete(@Path("id") id:Int): Response<Void>
}