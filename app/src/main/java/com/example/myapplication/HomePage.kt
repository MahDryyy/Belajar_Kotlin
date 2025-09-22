package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button // Added import for Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController // Added import for NavController

@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Home Page!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { 
            navController.navigate("login") {

                popUpTo("login") { inclusive = true }

                launchSingleTop = true
            }
        }) {
            Text("Logout")
        }
        Button(onClick = {
            navController.navigate("listMakanan") {
                launchSingleTop = true
                popUpTo("listMakanan") { inclusive = true }
            }

        }) {
            Text("Lihat Makanan")
        }
    }
}
