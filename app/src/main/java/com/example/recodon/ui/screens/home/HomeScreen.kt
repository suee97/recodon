package com.example.recodon.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recodon.components.GoalResetButton
import com.example.recodon.components.GoalView
import com.example.recodon.components.NowPoint
import com.example.recodon.components.PointResetButton
import com.example.recodon.data.models.FeedObject
import com.example.recodon.data.models.UserInfo
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import com.example.recodon.utils.RequestState

@Composable
fun HomeScreen(
    viewModel: FeedEarthViewModel
) {
    // Fetch Data =========================================================================
    LaunchedEffect(key1 = true) {
        viewModel.getAllInfo()
    }

    val allInfos by viewModel.allInfo.collectAsState()
    var curPoint by remember { mutableStateOf(0) }
    var goalIndex by remember { mutableStateOf(0) }

    val goalList = listOf<String>(
        "음식 남기지 않기",
        "대중교통 이용하기",
        "분리수거 신경써서 하기",
        "일회용품 컵 대신 텀블러나 머그컵 사용하기",
        "양치컵 사용하기",
        "쓰레기는 챙겼다가 분리수거하기",
        "나무젓가락 사용하지 않기"
    )

    if (allInfos is RequestState.Success) {
        if ((allInfos as RequestState.Success<List<UserInfo>>).data.isEmpty()) {
            val emptyInfo = UserInfo(1, "nick_name", FeedObject.Tree, 0, 0)
            viewModel.addInfo(userInfo = emptyInfo)
            curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point
            goalIndex = (allInfos as RequestState.Success<List<UserInfo>>).data[0].goalIndex
        } else {
            // 모든 데이터 로그
            Log.d(
                "suee97", "allInfos => " +
                        "${(allInfos as RequestState.Success<List<UserInfo>>).data[0]}"
            )
            curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point
            goalIndex = (allInfos as RequestState.Success<List<UserInfo>>).data[0].goalIndex

        }
    } else {
        Log.d("suee97", "allInfos RequestState is failed")
    }
    // =====================================================================================



    // View ================================================================================
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                NowPoint(
                    curPoint = curPoint,
                    onClick = { viewModel.updatePoint() }
                )
                PointResetButton(onClick = { viewModel.resetPoint() })
                GoalResetButton(
                    onClick = {
                        if(goalIndex >= 99) {
                            viewModel.resetGoalIndex()
                        } else {
                            viewModel.updateGoalIndex()
                        }
                    }
                )
                GoalView(
                    goalList = goalList,
                    goalIndex = goalIndex
                )
            }
        }
    )
    // ====================================================================================
}

