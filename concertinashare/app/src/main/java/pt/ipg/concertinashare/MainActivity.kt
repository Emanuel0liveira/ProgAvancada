package pt.ipg.concertinashare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.ipg.concertinashare.ui.theme.ConcertinaShareTheme
import java.util.Random
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()  // permite UI em edge-to-edge :contentReference[oaicite:1]{index=1}
        super.onCreate(savedInstanceState)
        setContent {
            ConcertinaShareTheme {
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
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
fun MainMenu(onPortugalClick: () -> Unit,
             onSuicaClick: () -> Unit,
             onAlemanhaClick: () -> Unit,
             onItaliaClick: () -> Unit){}
@Composable
fun ConcPortugal(onBack: () -> Unit){}
@Composable
fun ConcSuica(onBack: () -> Unit){}
@Composable
fun ConcAlemanha(onBack: () -> Unit){}
@Composable
fun ConcItalia(onBack: () -> Unit){}