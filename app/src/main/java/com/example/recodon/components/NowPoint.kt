package com.example.recodon.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun NowPoint(
    curPoint: Int,
    onClick: () -> Unit
) {
    Text(
        text = curPoint.toString(),
        fontSize = 30.sp
    )
    Button(onClick = {
        onClick()
    }) {
        Text("point + 1", fontSize = 30.sp)
    }
}