package com.example.recodon.ui.screens.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate("home")
    }

    Text(
        text = "스플래쉬 화면",
        fontSize = 30.sp
    )
}