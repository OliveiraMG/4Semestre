package sptech.projeto09c

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto09c.ui.theme.Projeto09CTheme


/*
Aqui criamos um objeto do tipo DataStore que
guarda seus dados em "disco" (memória interna do celular)
O "humor" é como se fosse o nome da "tabela".
Foi criado fora da classe para poder ser usado por outras Activities
 */
val Context.humorUsuario: DataStore<Preferences>
                            by preferencesDataStore("humor")

// Preferences do androidx.datastore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto09CTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tela(humorUsuario)
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Tela(dataStore: DataStore<Preferences>? = null, modifier: Modifier = Modifier) {

    val humorAtual = remember{ MutableLiveData("") }
    val novoHumor = remember{ mutableStateOf("") }

    Column {
        if (humorAtual.observeAsState().value!!.isNotBlank()) {
            Text("Seu humor hoje: ${humorAtual.observeAsState().value}")
        } else {
            /*
            Sempre que formos LER ou ESCREVER num Data Store
            devemos fazer isso numa Coroutine (ou similar)
             */
            CoroutineScope(Dispatchers.IO).launch {
                // aqui estamos LENDO dados da Data Store
                dataStore!!.data.collect {
                    // na linha abaixo recuperamos o dado "humor" do Data Store
                    val humor = it[stringPreferencesKey("humor")] ?: "(NA)"
                    // na linha abaixo TEMOS QUE usar postValue()
                    // pois estamos dentro de uma Coroutine
                    humorAtual.postValue(humor)
                    // humorAtual.value = humor // assim dá erro em tempo de execução
                }
            }
        }
        TextField(
            value = novoHumor.value,
            onValueChange = { novoHumor.value = it },
            label = { Text("Seu novo humor") }
        )
        Button(onClick = {
            /*
            Sempre que formos LER ou ESCREVER num Data Store
            devemos fazer isso numa Coroutine (ou similar)
             */
            CoroutineScope(Dispatchers.IO).launch {
                // aqui estamos ESCREVENDO dados da Data Store
                dataStore!!.edit { dados ->
                    val novo = novoHumor.value
                    // na linha abaixo estamos mudando o valor do dado "humor"
                    dados[stringPreferencesKey("humor")] = novo

                    // na linha abaixo TEMOS QUE usar postValue()
                    // pois estamos dentro de uma Coroutine
                    humorAtual.postValue(novo)
                }
            }
        }) {
            Text("Atualizar humor")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projeto09CTheme {
        Tela(null)
    }
}