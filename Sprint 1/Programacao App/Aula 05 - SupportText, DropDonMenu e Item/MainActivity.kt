package sptech.projeto03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import sptech.projeto03.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
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

    val clicado = remember { mutableStateOf(false) }
    val genero = remember { mutableStateOf(GeneroMusical("",0,"")) }
    val expandido = remember { mutableStateOf(false) }

    val generos = remember {
        mutableStateListOf(
            GeneroMusical("Pagode", 9, "Raça Negra"),
            GeneroMusical("Romântica", 10, "Brian Adams"),
            GeneroMusical("Clássica", 3, "Mozart")
        )
    }

    Column {
        TextButton(onClick = { expandido.value = true }) {
            Text("Sou um texto clicável! Escolha seu gênero musical")
        }
        if (clicado.value) {
            Text("Ufa! Que bom que clicou!")
        }
        Box {
            DropdownMenu(
                expanded = expandido.value,
                onDismissRequest = {
                    // quando clica "fora"
                    expandido.value = false
                }
            ) {
                DropdownMenuItem(
                    text = {
                    Text("Qual o gênero?",
                        style = TextStyle(color = Color.Gray))
                    },
                    onClick = { expandido.value = false }
                )
                Divider()
                generos.forEach {
                    DropdownMenuItem(
                        text = { Text(it.nome) }, onClick = {
                            genero.value = it
                            expandido.value = false
                        })
                }
                /*DropdownMenuItem(
                    text = { Text("Pagode") }, onClick = {
                        genero.value = "Pagode"
                        expandido.value = false
                    })
                DropdownMenuItem(
                    text = { Text("Romântica") }, onClick = {
                        genero.value = "Romântica"
                        expandido.value = false
                    })*/
            }
        }
        /*Text(if (genero.value.isBlank()) "- Selecione -"
             else "Seu gênero musical favorito é ${genero.value}")
*/
        if (genero.value.nome.isNotBlank()) {
            Text("Seu gênero favorito é ${genero.value.nome}")
            Text("A popularidade dele é ${genero.value.popularidade}")
            Text("Principal representante: ${genero.value.representante}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Tela("Android")
    }
}