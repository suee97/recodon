package com.example.recodon.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun NowPoint(
    curPoint: Int
) {
    Text(
        text = "point: ${curPoint}",
        fontSize = 18.sp
    )
}