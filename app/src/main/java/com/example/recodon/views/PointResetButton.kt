package com.example.recodon.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 초기화 버튼
@Composable
fun PointResetButton(
    onClick: () -> Unit
) {
    Row(
//        modifier = Modifier.border(2.dp, Color.Red),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("포인트 초기화", fontSize = 20.sp)
        IconButton(onClick = {
            onClick()
        }) {
            Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Reset Button")
        }
    }
}