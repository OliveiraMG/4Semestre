package com.example.projeto01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.projeto01.ui.theme.Projeto01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tela()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tela() {

    val entradaFrase = remember { mutableStateOf("") }
    val entradaNumero = remember { mutableStateOf("") }
    val entradaNota1 = remember { mutableStateOf("") }
    val entradaNota2 = remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text("Bom dia")
    Row() {
        Text("Café",
            Modifier
                .background(Color.Yellow)
                .padding(20.dp))
        Text("Lanche da manhã",
            Modifier
                .background(Color.Cyan)
                .padding(PaddingValues(start = 15.dp, end = 5.dp)))
    }
    Text("Boa tarde", fontStyle = FontStyle.Italic)
    Text("Boa noite", color = Color.Red)
//        Text("Boa noite", color = Color(200, 255, 0, 161))
    TextoVerdeBranco("Aí sim!")
    TextoVerdeBranco("Num diga!")

    if (entradaFrase.value.isNotBlank()) {
        TextoVerdeBranco("Você digitou ${entradaFrase.value}")
    }

    TextField(
        value = entradaFrase.value,
        onValueChange = { entradaFrase.value = it },
        label = { Text("Digite uma frase") },
        placeholder = { Text("Digita lógu") }
    )

    TextField(
        value = entradaNumero.value,
        onValueChange = { entradaNumero.value = it },
        label = { Text("Digite um número") },
        keyboardOptions =
            KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    if (entradaNumero.value.isNotBlank()) {
        Text(
        "O dobro do número é ${entradaNumero.value.toDouble() * 2}")
    }


    TextField(
        value = entradaNota1.value,
        onValueChange = { entradaNota1.value = it },
        label = { Text("Digite a 1a nota") },
        keyboardOptions =
        KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    TextField(
        value = entradaNota2.value,
        onValueChange = { entradaNota2.value = it },
        label = { Text("Digite a 2a nota") },
        keyboardOptions =
        KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    if (entradaNota1.value.isNotBlank() && entradaNota2.value.isNotBlank()) {
        entradaNota1.value.isDigitsOnly()
        val nota1 = entradaNota1.value.toDouble()
        val nota2 = entradaNota2.value.toDouble()

        var resultado = "Notas inválidas"
        if (nota1 in 0.0..10.0 && nota2 in 0.0..10.0) {
            resultado = "Média: ${(nota1+nota2)/2}"
        }

        Text(resultado)
    }

}
}

@Composable
fun TextoVerdeBranco(conteudo: String) {
    Box(modifier = Modifier.padding(10.dp)) {
        Text(
            conteudo,
            Modifier
                .background(Color.Green)
                .padding(10.dp),
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Projeto01Theme {
        Tela()
    }
}