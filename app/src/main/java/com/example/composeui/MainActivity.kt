package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeui.ui.theme.ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingScreen()
                }
            }
        }
    }
}

@Composable
fun GreetingScreen() {
    // State to store user input
    var name by remember { mutableStateOf(TextFieldValue("")) }

    // State to store greeting message
    var message by remember { mutableStateOf("") }

    // UI Layout using Column (like LinearLayout vertical)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Enter Your Name",
            style = MaterialTheme.typography.titleLarge
        )

        // TextField for user input
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to submit
        Button(
            onClick = {
                message = "Hello ${name.text}!"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Say Hello")
        }

        // Show the greeting message
        if (message.isNotEmpty()) {
            Text(
                text = message,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    ComposeUITheme {
        GreetingScreen()
    }
}
