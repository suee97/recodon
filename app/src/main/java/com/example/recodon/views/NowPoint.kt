package com.example.recodon.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.R
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import com.example.recodon.ui.theme.CustomFont1
import com.example.recodon.ui.theme.CustomFont2

@Composable
fun NowPoint(
    viewModel: FeedEarthViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "Point ${viewModel.curPoint} / 20",
            fontSize = 18.sp,
            fontFamily = CustomFont2,
            fontWeight = FontWeight.Normal
        )
    }
}