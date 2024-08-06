package sptech.projeto08c

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto08c.ui.theme.Projeto08CTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto08CTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tela("Android")
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Tela(name: String, modifier: Modifier = Modifier) {
    val sorteado = remember { mutableStateOf(-1) }
    val alvo = 77

    CoroutineScope(Dispatchers.IO).launch {
        // importar do kotlin.random
        var sorteado2 = Random.nextInt(0, 10_000_000)
        while (sorteado2 != alvo) {
            sorteado2 = Random.nextInt(0, 10_000_000)
        }
        sorteado.value = sorteado2
    }
    Column {
        if (sorteado.value == alvo) {
            Text(
                "Finalmente foi sorteado o $alvo",
                style = TextStyle(fontSize = 45.sp)
            )
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Clica p/ passar o tempo")
        }
        ListaFilmes()
    }
}

@Composable
fun ListaFilmes(viewModel: FilmeViewModel = FilmeViewModel()) {
    val filmes = viewModel.filmes.observeAsState().value!!
    val erroApi = viewModel.erroApi.observeAsState().value!!

    if (erroApi.isNotBlank()) {
        Text(erroApi)
    }
    LazyColumn {
        items(items = filmes.toList()) {
            Text("O filme ${it.nome} custou R$${it.custoProducao}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projeto08CTheme {
        Tela("Android")
    }
}