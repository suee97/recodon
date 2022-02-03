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
            in 0..2 -> Text("STEP 1", fontSize = 30.sp)
            in 3..5 -> Text("STEP 2", fontSize = 30.sp)
            in 6..8 -> Text("STEP 3", fontSize = 30.sp)
            in 9..11 -> Text("STEP 4", fontSize = 30.sp)
            in 12..14 -> Text("STEP 5", fontSize = 30.sp)
            in 15..17 -> Text("STEP 6", fontSize = 30.sp)
            in 18..19 -> Text("STEP 7", fontSize = 30.sp)
            20 -> Text("COMPLETE", fontSize = 30.sp)
        }
    }
}

@Composable
fun ContentAnimation_Step1() {

    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(com.example.recodon.R.raw.bee)
    )

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(compositionResult.value, progress)

}