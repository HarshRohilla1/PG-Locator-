package com.example.pglocator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pglocator.Screens.LoginScreen
import com.example.pglocator.ui.theme.PGLocatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PGLocatorTheme {
                val viewModel : AuthViewModel by viewModels()
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) { innerPadding ->

                    NavigationFile(authViewModel = viewModel, modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

