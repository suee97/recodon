package com.example.recodon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodolistMsg(
    msg: String
) {
    Box() {
        Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = msg,
                fontSize = 20.sp,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 100, heightDp = 100)
@Composable
fun TodolistMsgPrev() {
    TodolistMsg(msg = "오늘의 목표")
}