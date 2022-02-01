package com.example.recodon.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.recodon.data.models.FeedObject
import com.example.recodon.data.models.UserInfo
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import com.example.recodon.utils.RequestState

@Composable
fun HomeScreen(
    viewModel: FeedEarthViewModel
) {
    // 모든 정보가져오기
    LaunchedEffect(key1 = true) {
        viewModel.getAllInfo()
    }

    val allInfos by viewModel.allInfo.collectAsState()
    var curPoint by remember { mutableStateOf(0) }

    if (allInfos is RequestState.Success) {
        if ((allInfos as RequestState.Success<List<UserInfo>>).data.isEmpty()) {
            val emptyInfo = UserInfo(1, "nick_name", FeedObject.Tree, 0)
            viewModel.addInfo(userInfo = emptyInfo)
        } else {
            // 모든 데이터 로그
            Log.d(
                "suee97", "allInfos => " +
                        "${(allInfos as RequestState.Success<List<UserInfo>>).data[0]}"
            )
            curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point

        }
    } else {
        Log.d("suee97", "allInfos RequestState is failed")
    }

    // View
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                nowPoint(
                    curPoint = curPoint,
                    onClick = { viewModel.updatePoint() }
                )
            }
        }
    )
}

@Composable
fun nowPoint(
    curPoint: Int,
    onClick: () -> Unit
) {
    Text(
        text = curPoint.toString(),
        fontSize = 30.sp
    )
    Button(onClick = {
        onClick()
    }) {
        Text("update point", fontSize = 30.sp)
    }
}