package com.example.pglocator.Screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pglocator.AuthState
import com.example.pglocator.AuthViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel)
{
    val authState  = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value)
        {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else->Unit
        }

    }

    Column(
        modifier = Modifier.fillMaxSize(),

    ) {
        Text(text = "Home Page", fontSize = 32.sp, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 40.dp))
        Box(modifier = Modifier.wrapContentSize() ) {
            TextButton(
                onClick = {
                    authViewModel.signout()
                },
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Text(text = "Sign out",)
            }
        }

    }


}