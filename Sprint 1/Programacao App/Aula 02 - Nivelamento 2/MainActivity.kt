package com.example.projeto01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun Tela() {
    Column() {
        Text("Bom dia")
        Row() {
            Text("Café da manhã")
            Text("Lanche da manhã")
        }
        Text("Boa tarde", fontStyle = FontStyle.Italic)
        Text("Boa noite", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Projeto01Theme {
        Tela()
    }
}