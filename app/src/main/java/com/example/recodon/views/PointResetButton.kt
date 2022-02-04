package com.example.recodon.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.ui.theme.CustomFont1

// 초기화 버튼
@Composable
fun PointResetButton(
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(
                Color(0xFF7CBFAB),
                shape = RoundedCornerShape(12.dp)
            )
            .height(40.dp)
            .alpha(0.5f)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "새 시작",
            fontSize = 20.sp,
            fontFamily = CustomFont1,
            fontWeight = FontWeight.Normal
        )
        Icon(
            modifier = Modifier.padding(end = 8.dp).clickable { onClick() },
            imageVector = Icons.Filled.Refresh,
            contentDescription = "Reset Button"
        )
    }
}