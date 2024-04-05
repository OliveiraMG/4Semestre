package com.example.projeto05

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun TelaFruta1() {
    Text(text = "Sou uma Manga", style = TextStyle(fontSize = 35.sp, color = Color.Cyan))
}

@Composable
fun TelaFruta2() {
    Text(text = "Sou um Abacaxi", style = TextStyle(fontSize = 35.sp, color = Color.Yellow))
}

@Composable
fun TelaFruta3() {
    Text(text = "Sou uma Maracuja", style = TextStyle(fontSize = 35.sp, color = Color.Red))
}