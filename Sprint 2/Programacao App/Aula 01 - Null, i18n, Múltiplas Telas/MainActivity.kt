package com.example.projeto04

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.projeto04.ui.theme.Projeto04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto04Theme {
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

    val contexto = LocalContext.current

    val (produto, produtoSetter) = remember { 
                                    mutableStateOf(Produto()) 
                                   }


    Column {
        // stringResource() recupera um valor i18n do strings.xml
        Text(stringResource(R.string.txt_bom_dia))
        Text(stringResource(R.string.txt_boa_tarde))
        Text(stringResource(R.string.txt_boa_noite))

        TextField(
            label = { Text(text = "Nome") },
            value = produto.nome,
            onValueChange = { produtoSetter(produto.copy(nome = it)) }
        )
        TextField(
            label = { Text(text = "Preço") },
            value = produto.preco.toString(),
            onValueChange = {
                produtoSetter(produto.copy(preco = it.toDouble()))
            }
        )
        Text("É perecível")
        Switch(checked = produto.perecivel,
            onCheckedChange = {
                produtoSetter(produto.copy(perecivel = it))
            })
        
        Button(onClick = {
            // Aqui nós criamos uma Intent
            // esse tipo de objeto PREPARA a inicialização de outra Activity
            val tela2 = Intent(contexto, Tela2::class.java)

            // enviando dados para a Tela2
            /*tela2.putExtra("produto", "Arroz")
            tela2.putExtra("preco", 3.50)
            tela2.putExtra("perecivel", false)*/
            tela2.putExtra("produto", produto)

            // aqui nós inicializamos a Tela2
            contexto.startActivity(tela2)
        }) {
            Text(stringResource(R.string.txt_tela2))
            // Ir para a 2a tela
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projeto04Theme {
        Tela("Android")
    }
}