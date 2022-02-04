package com.example.recodon.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*
import com.example.recodon.data.viewmodels.FeedEarthViewModel

@Composable
fun AnimationView(
    viewModel: FeedEarthViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (viewModel.curPoint) {
            in 0..2 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.step_1)
            }
            in 3..5 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.step_2)
            }
            in 6..8 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.step_3)
            }
            in 9..11 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.step_4)
            }
            in 12..14 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.step_5)
            }
            in 15..17 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.step_6)
            }
            in 18..19 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.new7)
            }
            20 -> {
                ContentAnimation(rawInt = com.example.recodon.R.raw.new7)
            }
        }
    }
}

@Composable
fun ContentAnimation(rawInt: Int) {

    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(rawInt)
    )

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(compositionResult.value, progress)

}