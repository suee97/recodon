package com.example.recodon.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
import com.example.recodon.R
import com.example.recodon.ui.theme.CustomFont2

@Composable
fun GoalResetButton(
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(
                Color(0xFF7CBFAB),
                shape = RoundedCornerShape(12.dp)
            )
            .height(40.dp)
            .alpha(0.5f)
    ) {
        Text("다음 날로 이동",
            fontSize = 20.sp,
            fontFamily = CustomFont2,
            fontWeight = FontWeight.Normal
        )
        IconButton(onClick = {
            onClick()
        }) {
            Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Reset Button")
        }
    }
}