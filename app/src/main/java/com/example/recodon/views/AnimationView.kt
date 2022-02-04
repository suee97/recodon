package com.example.recodon.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*

@Composable
fun AnimationView(
    curPoint: Int
) {

    // Lottie Animation 으로 바꿔야 함
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Red)
    ) {
        when (curPoint) {
            in 0..2 -> {}
            in 3..5 -> {}
            in 6..8 -> {}
            in 9..11 -> {}
            in 12..14 -> {}
            in 15..17 -> {}
            in 18..19 -> {}
            20 -> {}
        }
    }
}

@Composable
fun ContentAnimation(type: Int) {

    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(com.example.recodon.R.raw.splashimage)
    )

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(compositionResult.value, progress)

}