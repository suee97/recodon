package com.example.recodon.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.example.recodon.data.viewmodels.FeedEarthViewModel

@Composable
fun EmptyVisibleState(
    viewModel: FeedEarthViewModel,
    onClick: () -> Unit
) {
    Box() {
        Column(
            modifier = Modifier.fillMaxWidth().border(2.dp, Color.Black),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "오늘의 목표를 모두 완수하셨습니다.",
                fontSize = 21.sp
            )
            Text(
                text = "00:00:00 뒤에 목표가 초기화됩니다.",
                fontSize = 21.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "수동으로 초기화하기",
                    fontSize = 21.sp
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