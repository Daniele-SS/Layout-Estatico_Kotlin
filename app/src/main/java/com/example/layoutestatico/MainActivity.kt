package com.example.layoutestatico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutestatico.ui.theme.LayoutEstaticoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutEstaticoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Estado para alternar entre as telas no app real
                    var currentScreen by remember { mutableStateOf(1) }

                    Box(modifier = Modifier.padding(innerPadding)) {
                        if (currentScreen == 1) {
                            GameScreen(onPressStart = { currentScreen = 2 })
                        } else {
                            GameOverScreen(onReset = { currentScreen = 1 })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GameScreen(onPressStart: () -> Modifier = {}, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "SCORE: 0050",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "LIVES: ",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                // Ícones de vidas (3 triângulos/naves verdes)
                repeat(3) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Life",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        // Inimigos (Aliens coloridos)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val colors = listOf(Color.Green, Color.Red, Color.Blue, Color.Yellow, Color.Green)
            colors.forEach { color ->
                Icon(
                    imageVector = Icons.Default.Android,
                    contentDescription = "Enemy",
                    tint = color,
                    modifier = Modifier.size(45.dp)
                )
            }
        }

        // Espaçador central para empurrar o jogador para baixo
        Spacer(modifier = Modifier.weight(1f))

        // Jogador (Nave/Cubo na parte inferior)
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color(0xFF4CAF50), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            // Um detalhe interno para simular o design do cubo da imagem
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .background(Color(0xFF1B5E20), shape = RoundedCornerShape(4.dp))
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "PRESS START",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun GameOverScreen(onReset: () -> Unit = {}, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "GAME OVER",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@Preview(showBackground = true, name = "Tela do Jogo")
@Composable
fun GameScreenPreview() {
    LayoutEstaticoTheme {
        GameScreen()
    }
}

@Preview(showBackground = true, name = "Tela Game Over")
@Composable
fun GameOverScreenPreview() {
    LayoutEstaticoTheme {
        GameOverScreen()
    }
}