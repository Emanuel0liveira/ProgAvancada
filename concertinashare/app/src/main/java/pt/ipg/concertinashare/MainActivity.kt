package pt.ipg.concertinashare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.ipg.concertinashare.ui.theme.ConcertinaShareTheme
import android.content.Context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ConcertinaShareTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppController(LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun AppController(context: Context) {
    var showConcPortugal by remember { mutableStateOf(false) }
    var showConcSuica by remember { mutableStateOf(false) }
    var showConcAlemanha by remember { mutableStateOf(false) }
    var showConcItalia by remember { mutableStateOf(false) }

    when {
        showConcPortugal -> ConcPortugal(onBack = { showConcPortugal = false })
        showConcSuica -> ConcSuica(onBack = { showConcSuica = false })
        showConcAlemanha -> ConcAlemanha(onBack = { showConcAlemanha = false })
        showConcItalia -> ConcItalia(onBack = { showConcItalia = false })
        else -> MainMenu(
            onPortugalClick = { showConcPortugal = true },
            onSuicaClick = { showConcSuica = true },
            onAlemanhaClick = { showConcAlemanha = true },
            onItaliaClick = { showConcItalia = true }
        )
    }
}

@Composable
fun MainMenu(
    onPortugalClick: () -> Unit,
    onSuicaClick: () -> Unit,
    onAlemanhaClick: () -> Unit,
    onItaliaClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.backg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onPortugalClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF32212)
                )
            ) {
                Text(text = "Portugal", color = Color.White)
            }

            Button(
                onClick = onSuicaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF)
                )
            ) {
                Text(text = "Suiça", color = Color.Black)
            }

            Button(
                onClick = onAlemanhaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFEB3B)
                )
            ) {
                Text(text = "Alemanha", color = Color.Black)
            }

            Button(
                onClick = onItaliaClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {
                Text(text = "Italia", color = Color.White)
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ConcPortugal(onBack: () -> Unit) {}
@Composable
fun ConcSuica(onBack: () -> Unit) {}
@Composable
fun ConcAlemanha(onBack: () -> Unit) {}
@Composable
fun ConcItalia(onBack: () -> Unit) {}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    ConcertinaShareTheme {
        MainMenu(
            onPortugalClick = {},
            onSuicaClick = {},
            onAlemanhaClick = {},
            onItaliaClick = {}
        )
    }
}
