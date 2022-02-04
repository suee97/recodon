package com.example.recodon.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.West
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.R
import com.example.recodon.ui.theme.CustomFont1

@Composable
fun TodolistMsg(
    msg: String
) {
    Box() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val fontFamily = FontFamily(
                Font(R.font.gowunbatang_bold, FontWeight.Bold),
                Font(R.font.gowunbatang_regular, FontWeight.Normal)
            )
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Filled.West,
                contentDescription = "Swipe Icon"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = msg,
                fontSize = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
