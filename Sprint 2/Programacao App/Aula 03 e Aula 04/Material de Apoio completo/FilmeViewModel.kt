package com.example.navegacao

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class FilmeViewModel:ViewModel() {

    val filmeAtual = MutableLiveData(Filme())

    val filmes = MutableLiveData(SnapshotStateList<Filme>())

    val erroApi = MutableLiveData("")

    private val apiFilmes = RetrofitService.getApiFilmesService()

    init {
        apiFilmes.get().enqueue(object : Callback<List<Filme>> {
            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                if (response.isSuccessful) {
                    filmes.value!!.addAll(response.body()!!)
                    erroApi.value = ""
                } else {
                    erroApi.value = response.errorBody()?.string() ?: ""
                }
            }

            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                erroApi.value = t.message!!
            }
        })
    }


    fun setFilmeAtual(filme: Filme) {
        filmeAtual.value = filme
    }

    fun salvarFilme() {
        val filme = filmeAtual.value!!

        val id = filme.id

        if (id == null) {
            apiFilmes.post(filme).enqueue(object : Callback<Filme> {
                override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                    if (response.isSuccessful) {
                        val novo = response.body()!!
                        filmes.value!!.add(novo)
                        filmeAtual.value = Filme()
                        erroApi.value = ""
                    } else {
                        erroApi.value = response.errorBody()?.string() ?: ""
                    }
                }

                override fun onFailure(call: Call<Filme>, t: Throwable) {
                    erroApi.value = t.message!!
                }
            })
        } else {
            apiFilmes.put(id, filme).enqueue(object : Callback<Filme> {
                override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                    if (response.isSuccessful) {
                        val atualizado = response.body()!!
                        atualizarFilme(id)
                        filmeAtual.value = atualizado
                        erroApi.value = ""
                    } else {
                        erroApi.value = response.errorBody()?.string() ?: ""
                    }
                }

                override fun onFailure(call: Call<Filme>, t: Throwable) {
                    erroApi.value = t.message!!
                }
            })
        }
    }

    fun atualizarFilme(id: Int) {
        val lista = filmes.value!!
        lista[lista.indexOfFirst{ it.id == id }] = filmeAtual.value!!
    }

    fun removerFilme(filme: Filme) {
        apiFilmes.delete(filme.id ?: 0).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    filmes.value!!.remove(filme)
                    erroApi.value = ""
                } else {
                    erroApi.value = response.errorBody()?.string() ?: ""
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                erroApi.value = t.message!!
            }
        })
    }
}