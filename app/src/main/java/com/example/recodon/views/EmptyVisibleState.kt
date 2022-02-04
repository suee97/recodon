package com.example.recodon.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import com.example.recodon.ui.theme.CustomFont1

@Composable
fun EmptyVisibleState(
    viewModel: FeedEarthViewModel,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                Color(0xFFD79F9F),
                shape = RoundedCornerShape(12.dp)
            )
            .alpha(0.5f)
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "오늘의 목표를 모두 완수하셨습니다",
                fontSize = 21.sp,
                fontFamily = CustomFont1,
                fontWeight = FontWeight.Normal
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "수동으로 초기화",
                    fontSize = 21.sp,
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
    }
}