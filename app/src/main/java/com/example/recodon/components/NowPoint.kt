package com.example.recodon.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.data.viewmodels.FeedEarthViewModel

@Composable
fun NowPoint(
    viewModel: FeedEarthViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Magenta),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "point: ${viewModel.curPoint}",
            fontSize = 18.sp
        )
    }
}