package com.example.recodon.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationView(
    curPoint: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Magenta)
    ) {
        when(curPoint) {
            in 0..2 -> Text("STEP 1", fontSize = 30.sp)
            in 3..5 -> Text("STEP 2", fontSize = 30.sp)
            in 6..8 -> Text("STEP 3", fontSize = 30.sp)
            in 9..11 -> Text("STEP 4", fontSize = 30.sp)
            in 12..14 -> Text("STEP 5", fontSize = 30.sp)
            in 15..17 -> Text("STEP 6", fontSize = 30.sp)
            in 18..20 -> Text("STEP 7", fontSize = 30.sp)
        }
    }
}