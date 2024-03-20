package com.example.projeto02adsc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto02adsc.ui.theme.Projeto02AdsCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto02AdsCTheme {
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

@Composable
fun Tela(name: String, modifier: Modifier = Modifier) {

    //  é mutableStateOf NÃO É mutableList!!!!
    val mensagemContador = remember { mutableStateOf("") }
    val contador = remember { mutableStateOf(0) }

    val frase = remember { mutableStateOf("") }

    val frutas = remember {
        mutableStateListOf<String>()
    }

    val frutasObjetos = remember {
        mutableStateListOf<Fruta>()
    }

    val novaFruta = remember { mutableStateOf("") }
    val novoPrecoFruta = remember { mutableStateOf("") }

    Column {
        /*Button(onClick = { contador.value++ }) {
            Text("Clica nimin!", style = TextStyle(fontSize = 30.sp))
        }

        if (contador.value > 0) {
            Text("Você já clicou ${contador.value} vezes")
        }*/

        if (contador.value < 5) {
            Button(onClick = {
                contador.value++
                mensagemContador.value = "Você já clicou ${contador.value} vezes"
            }) {
                Text("Clica nimin!", style = TextStyle(fontSize = 30.sp))
            }
        }

        if (mensagemContador.value.isNotBlank()) {
            Text(mensagemContador.value)
        }

        TextField(
            value = frase.value,
            onValueChange = { frase.value = it },
            label = { Text("Frase bonita") },
            supportingText = {
                if (frase.value.length < 5) {
                    Text(
                        "Deve ter 5 ou mais letras",
                        color = Color.Red
                    )
                }
            }
        )

        Image(
            painter = painterResource(id = R.mipmap.morango),
            contentDescription = "Foto de um morango",
            modifier = Modifier.fillMaxWidth(0.2f)
        )

        TextField(
            value = novaFruta.value,
            onValueChange = {
                novaFruta.value = it
            },
            label = { Text("Nova fruta")}
        )
        TextField(
            value = novoPrecoFruta.value,
            onValueChange = {
                novoPrecoFruta.value = it
            },
            label = { Text("Preço")}
        )/*
        Button(onClick = { frutas.add(novaFruta.value) }) {
            Text("Adicionar Fruta")
        }*/
        Button(onClick = {
            val novaFrutaObj =
                Fruta(novaFruta.value, novoPrecoFruta.value.toDouble())

            frutasObjetos.add(novaFrutaObj)
        }) {
            Text("Adicionar Fruta")
        }

        /*frutas.forEach {
            Text(it)
        }*/
        Text(if (frutasObjetos.isEmpty()) "Nenhuma fruta" else "${frutasObjetos.size} Frutas")
/*
        LazyColumn {
            items(items = frutas.toList()) {
                Text(it)
            }
        }*/

        LazyColumn {
            items(items = frutasObjetos.toList()) {
                TextoFruta(it)
            }
        }

    }

}

@Composable
fun TextoFruta(fruta: Fruta) {
    Row {
        Text(fruta.nome, fontStyle = FontStyle.Italic, modifier = Modifier.padding(end = 20.dp))
        Text("Preço: R$ ${fruta.preco}", color = Color.Green)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projeto02AdsCTheme {
        Tela("Android")
    }
}