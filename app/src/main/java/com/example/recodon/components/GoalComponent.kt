package com.example.recodon.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// 슬라이드
@Composable
fun GoalComponent() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(4.dp))
            .border(2.dp, Color.Magenta)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 4.dp),
            text = "종이빨대 사용하기"
        )
    }
}

// 프리뷰
@Preview(showBackground = true)
@Composable
fun GoalComponentPrev() {
    GoalComponent()
}