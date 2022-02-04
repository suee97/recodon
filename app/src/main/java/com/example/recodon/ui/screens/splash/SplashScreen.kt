package com.example.recodon.ui.screens.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.recodon.R
import com.example.recodon.ui.theme.CustomFont2
import com.example.recodon.ui.theme.StatusColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController


// 스플래쉬 화면
@Composable
fun SplashScreen(
    navController: NavHostController
) {
    val systemUiController = rememberSystemUiController() // 상단 바 색상 조정
    systemUiController.setSystemBarsColor(color = Color.Transparent)

    LaunchedEffect(key1 = true) {
        delay(2500) // 테스트 때문에 줄여놓음. 원래 2~3초
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    SplashAnimation()

}

@Composable
private fun SplashAnimation() {
    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(
                R.raw.splash_lottie
            )
        )
    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            LottieAnimation(
                compositionResult.value,
                progress,
                modifier = Modifier.size(250.dp)
            )
            Text(
                "Feed\bThe Earth",
                color = Color(0xFF479156),
                fontSize = 30.sp,
                fontFamily = CustomFont2,
                modifier = Modifier
                    .padding(2.dp),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        }
    }
}