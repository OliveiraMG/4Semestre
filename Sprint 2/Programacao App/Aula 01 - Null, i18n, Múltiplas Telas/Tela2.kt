package com.example.projeto04

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projeto04.ui.theme.Projeto04Theme

class Tela2 : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aqui recuperamos os dados enviados da tela anterior
        // esta operação DEVE ser feita neste local (no onCreate)
        val extras = intent.extras

        setContent {
            Projeto04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tela2(extras)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Tela2(extras: Bundle?) {
    /*val produto = extras?.getString("produto")
    val preco = extras?.getDouble("preco")
    val perecivel = extras?.getBoolean("perecivel")
    Text("Uhu! Estou na 2a tela! $produto - $preco - $perecivel")*/
    val prod = extras?.getSerializable("produto", Produto::class.java)
    Text("2a tela! ${prod?.nome} - ${prod?.preco} - ${prod?.perecivel}")
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Projeto04Theme {
        Tela2(null)
    }
}