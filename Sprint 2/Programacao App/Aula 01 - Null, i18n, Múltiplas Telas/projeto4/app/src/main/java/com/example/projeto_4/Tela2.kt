package com.example.projeto_4

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projeto_4.ui.theme.Produto
import com.example.projeto_4.ui.theme.Projeto4Theme

class Tela2 : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        setContent {
            Projeto4Theme {
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
fun Tela2(extras: Bundle?, modifier: Modifier = Modifier) {


    if(extras != null){
        val produto = extras.getSerializable("produto", Produto::class.java)!!

        Column {
            Text("Nome do produto: ${produto.nome}")
            Text("Preço: R$ ${produto.preco}")
            Text("Perecível: R$ ${produto.perecivel}")
        }
    }else{
        Text("Uhuuul, estou na segunda tela!")
    }

}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Projeto4Theme {
        Tela2(null)
    }
}