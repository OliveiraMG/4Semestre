package sptech.projeto08c

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmeViewModel:ViewModel() {
    val filmes = MutableLiveData(SnapshotStateList<Filme>())

    val erroApi = MutableLiveData("")

    private val apiFilmes = RetrofitService.getApiFilmesService()

    init {
        recuperarLista()
    }

    private fun recuperarLista() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiFilmes.get()
                if (response.isSuccessful) {
                    filmes.value!!.clear()
                    filmes.value!!.addAll(response.body() ?: emptyList())
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                Log.e("api", "Deu ruim no get! ${e.message}")
                erroApi.postValue(e.message)
            }
        }
    }

    fun criar(novoFilme: Filme) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val post = apiFilmes.post(novoFilme)
                if (post.isSuccessful) {
                    recuperarLista()
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(post.errorBody()!!.string())
                }
            } catch (e: Exception) {
                Log.e("api", "Deu ruim no post! ${e.message}")
                erroApi.postValue(e.message)
            }
        }
    }
}