package com.example.recodon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 100, heightDp = 200)
@Composable
fun TodolistMsgPrev() {
    TodolistMsg(msg = "To do list")
}