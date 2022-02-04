package com.example.recodon.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.recodon.data.viewmodels.FeedEarthViewModel

@Composable
fun AnimationView(
    viewModel: FeedEarthViewModel
) {

    // Lottie Animation 으로 바꿔야 함
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Red)
    ) {
        when (viewModel.curPoint) {
            in 0..2 -> {
                ContentAnimation(
                    rawInt = com.example.recodon.R.raw.step1,
                    modifier = Modifier.offset(y = 220.dp)
                )
            }
            in 3..5 -> {
                ContentAnimation(
                    rawInt = com.example.recodon.R.raw.step1,
                    modifier = Modifier.offset(x = 100.dp, y = 220.dp)
                )
                ContentAnimation(
                    rawInt = com.example.recodon.R.raw.step2,
                    modifier = Modifier
                )
            }
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
fun ContentAnimation(rawInt: Int, modifier: Modifier) {

    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(rawInt)
    )

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(compositionResult.value, progress, modifier)

}