package com.example.recodon.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable

// 초기화 버튼
@Composable
fun ResetButton(
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Reset Button")
    }
}