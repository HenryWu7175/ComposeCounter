package edu.temple.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge // Optional: For edge-to-edge display
import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Using Material 3 components
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable // For state persistence
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource // To load drawable resources
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.temple.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    Column (modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { count++ }) {
            Text(text = "Add")
        }
        Text(
            text = "0",
            fontSize = 192.sp
        )
        Button(onClick = { count-- }) {
            Text(text = "Down")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        Counter()
    }
}