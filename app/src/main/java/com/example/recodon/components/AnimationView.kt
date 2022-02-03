package com.example.recodon.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AnimationView(
    curPoint: Int
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("애니메이션이 나올 공간입니다\ncurpoint: $curPoint")
    }
}