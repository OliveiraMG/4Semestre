package com.example.projeto05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projeto05.ui.theme.Projeto05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto05Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Tela(rememberNavController())
                }
            }
        }
    }
}

@Composable
fun Tela(navController: NavHostController, modifier: Modifier = Modifier) {
    Column {
        NavHost(modifier = modifier, navController = navController, startDestination = "Manga") {
            composable("MANGA") {
                TelaFruta1()
            }
            composable("ABACAXI") {
                TelaFruta2()
            }
            composable("MARACUJA") {
                TelaFruta3()
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Card(modifier = Modifier.weight(1f)) {
                TextButton(onClick = { navController.navigate("MANGA") }) {
                    Image(
                        painter = painterResource(id = R.mipmap.manga),
                        contentDescription = "Tela de Manga"
                    )
                }
            }

            Card(modifier = Modifier.weight(1f)) {
                TextButton(onClick = { navController.navigate("ABACAXI") }) {
                    Image(
                        painter = painterResource(id = R.mipmap.abacaxi),
                        contentDescription = "Tela de Abacaxi"
                    )
                }
            }

            Card(modifier = Modifier.weight(1f)) {
                TextButton(onClick = { navController.navigate("MARACUJA") }) {
                    Image(
                        painter = painterResource(id = R.mipmap.maracuja),
                        contentDescription = "Tela de Maracujá"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaPreview() {
    Projeto05Theme {
        Tela(rememberNavController())
    }
}