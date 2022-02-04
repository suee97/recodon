package com.example.recodon.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import kotlin.concurrent.timer

@Composable
fun EmptyVisibleState(
    viewModel: FeedEarthViewModel,
    onClick: () -> Unit
) {
    val fontFamily = FontFamily(
        Font(R.font.gowunbatang_bold, FontWeight.Bold),
        Font(R.font.gowunbatang_regular, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .background(
                Color(0xFFD79F9F),
                shape = RoundedCornerShape(12.dp)
            )
            .alpha(0.5f)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "오늘의 목표를 모두 완수하셨습니다.",
                fontSize = 21.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = " 뒤에 목표가 초기화됩니다.",
                fontSize = 21.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "수동으로 초기화하기",
                    fontSize = 21.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal
                )
                IconButton(onClick = {
                    onClick()
                }) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Reset Button")
                }
            }
        }
    }
}