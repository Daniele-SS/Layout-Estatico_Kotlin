package com.example.layoutestatico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutestatico.ui.theme.LayoutEstaticoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutEstaticoTheme() {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {

    // coluna base da tela
    Column(
        modifier = modifier
        .fillMaxSize()
        .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Score: 0050",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            // empurra o Score totalmente para a esquerda e o
            // painel de vidas totalmente para a direita
            Spacer(
                modifier = Modifier.weight(1f)
            )

            // informações do painel de vidas
            Text(
                text = "Lives: ",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(30.dp)
                    .padding(2.dp),
                color = Color.Green
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(30.dp)
                    .padding(2.dp),
                color = Color.Green
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(30.dp)
                    .padding(2.dp),
                color = Color.Green
            )

        }

        // fileira dos inimigos (verde, vermelho, azul, amarelo, verde)
        Column {
            Row {
                AndroidEnemy(
                    modifier = Modifier.size(80.dp),
                    color = Color.Green
                )

                AndroidEnemy(
                    modifier = Modifier.size(80.dp),
                    color = Color.Red
                )

                AndroidEnemy(
                    modifier = Modifier.size(80.dp),
                    color = Color.Blue
                )

                AndroidEnemy(
                    modifier = Modifier.size(80.dp),
                    color = Color.Yellow
                )

                AndroidEnemy(
                    modifier = Modifier.size(80.dp),
                    color = Color.Green
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .size(60.dp),
            contentAlignment = Alignment.Center
        ) {
            // Image(painter = painterResource(R.drawable.nome_do_seu_cubo),
            // contentDescription = null)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF4285F4), shape = RoundedCornerShape(12.dp))
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF34A853), shape = RoundedCornerShape(8.dp))
            )
        }

        // Botão de start
        Button (
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2D2D2D)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "PRESS START",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )
}