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

@Composable
fun NowPoint(
    viewModel: FeedEarthViewModel
) {
    val fontFamily = FontFamily(
        Font(R.font.gowunbatang_bold, FontWeight.Bold),
        Font(R.font.gowunbatang_regular, FontWeight.Normal)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "Point ${viewModel.curPoint} / 20",
            fontSize = 18.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}