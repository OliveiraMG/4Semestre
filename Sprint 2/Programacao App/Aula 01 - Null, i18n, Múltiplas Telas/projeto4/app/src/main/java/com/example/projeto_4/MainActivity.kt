package com.example.projeto_4

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.projeto_4.ui.theme.Produto
import com.example.projeto_4.ui.theme.Projeto4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tela1("Android")
                }
            }
        }
    }
}

@Composable
fun Tela1(name: String, modifier: Modifier = Modifier) {
    val contexto = LocalContext.current

    val (produto, produtoSetter) = remember {
        mutableStateOf(Produto())
    }


  Column {
      Text(stringResource(R.string.txt_bom_dia))
      Text(stringResource(R.string.txt_boa_tarde))
      Text("Boa noite")

      TextField(
          label = { Text(text = "Nome") },
          value = produto.nome!!,
          onValueChange = {
              produtoSetter(produto.copy(nome = it))
          }
      )

      TextField(
          label = { Text(text = "Preço") },
          value = produto.preco.toString(),
          onValueChange = {
              produtoSetter(produto.copy(preco = it.toDouble()))
          }
      )




      Button(onClick = {
          val tela2 = Intent(contexto, Tela2::class.java)

          tela2.putExtra("produto","arroz")
          tela2.putExtra("preco", 3.50)
          contexto.startActivity(tela2)

      }) {
        Text("Ir para a 2a tela")
      }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projeto4Theme {
        Tela1("Android")
    }
}