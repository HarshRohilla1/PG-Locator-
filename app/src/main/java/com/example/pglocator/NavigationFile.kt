package com.example.pglocator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pglocator.Screens.HomeScreen
import com.example.pglocator.Screens.LoginScreen
import com.example.pglocator.Screens.SignUpScreen

@Composable
fun NavigationFile(modifier: Modifier=Modifier,authViewModel: AuthViewModel)
{
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = "Login", builder = {
        composable("login"){
            LoginScreen(modifier,navController,authViewModel)
        }
        composable("signup"){
            SignUpScreen(modifier,navController,authViewModel)
        }
        composable("homepage"){
            HomeScreen(modifier,navController,authViewModel)
        }
    })
}