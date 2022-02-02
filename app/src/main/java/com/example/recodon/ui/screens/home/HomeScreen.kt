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
import com.example.recodon.data.models.UserInfo
import com.example.recodon.data.models.VisibleState
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
    var curVisibleState by remember { mutableStateOf(VisibleState.STATE_111) }

    val goalList = listOf<String>(
        "음식 남기지 않기",
        "대중교통 이용하기",
        "분리수거 신경써서 하기",
        "텀블러나 머그컵 사용하기",
        "양치컵 사용하기",
        "쓰레기 분리수거하기",
        "나무젓가락 사용하지 않기"
    )

    if (allInfos is RequestState.Success) {
        if ((allInfos as RequestState.Success<List<UserInfo>>).data.isEmpty()) {
            val emptyInfo = UserInfo(
                1,
                "nick_name",
                0,
                0,
                VisibleState.STATE_111
            )
            viewModel.addInfo(userInfo = emptyInfo)
            curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point
            goalIndex = (allInfos as RequestState.Success<List<UserInfo>>).data[0].goalIndex
            curVisibleState = (allInfos as RequestState.Success<List<UserInfo>>).data[0].visibleState
        } else {
            // 모든 데이터 로그
            Log.d(
                "suee97", "allInfos => " +
                        "${(allInfos as RequestState.Success<List<UserInfo>>).data[0]}"
            )
            curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point
            goalIndex = (allInfos as RequestState.Success<List<UserInfo>>).data[0].goalIndex
            curVisibleState = (allInfos as RequestState.Success<List<UserInfo>>).data[0].visibleState

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

                PointResetButton(onClick = { viewModel.resetPoint() })
                GoalResetButton(
                    onClick = {
                        if (goalIndex >= 99) {
                            val newInfo = UserInfo(
                                1,
                                "nick_name",
                                curPoint,
                                0,
                                VisibleState.STATE_111
                            )
                            viewModel.updateInfo(userInfo = newInfo)
                        } else {
                            val newInfo = UserInfo(
                                1,
                                "nick_name",
                                curPoint,
                                goalIndex + 3,
                                VisibleState.STATE_111
                            )
                            viewModel.updateInfo(userInfo = newInfo)
                        }
                    }
                )
                GoalView(
                    goalList = goalList,
                    goalIndex = goalIndex,
                    onFirstGoalSuccessClicked = {
                        when(curVisibleState) {
                            VisibleState.STATE_111 -> curVisibleState = VisibleState.STATE_011
                            VisibleState.STATE_110 -> curVisibleState = VisibleState.STATE_010
                            VisibleState.STATE_101 -> curVisibleState = VisibleState.STATE_001
                            VisibleState.STATE_100 -> curVisibleState = VisibleState.STATE_000
                        }
                        val newInfo = UserInfo(
                            1,
                            "nick_name",
                            curPoint + 1,
                            goalIndex,
                            curVisibleState
                        )
                        viewModel.updateInfo(userInfo = newInfo)
                    },
                    onSecondGoalSuccessClicked = {
                        when(curVisibleState) {
                            VisibleState.STATE_111 -> curVisibleState = VisibleState.STATE_101
                            VisibleState.STATE_110 -> curVisibleState = VisibleState.STATE_100
                            VisibleState.STATE_011 -> curVisibleState = VisibleState.STATE_001
                            VisibleState.STATE_010 -> curVisibleState = VisibleState.STATE_000
                        }
                        val newInfo = UserInfo(
                            1,
                            "nick_name",
                            curPoint + 1,
                            goalIndex,
                            curVisibleState
                        )
                        viewModel.updateInfo(userInfo = newInfo)
                    },
                    onThirdGoalSuccessClicked = {
                        when(curVisibleState) {
                            VisibleState.STATE_111 -> curVisibleState = VisibleState.STATE_110
                            VisibleState.STATE_101 -> curVisibleState = VisibleState.STATE_100
                            VisibleState.STATE_011 -> curVisibleState = VisibleState.STATE_010
                            VisibleState.STATE_001 -> curVisibleState = VisibleState.STATE_000
                        }
                        val newInfo = UserInfo(
                            1,
                            "nick_name",
                            curPoint + 1,
                            goalIndex,
                            curVisibleState
                        )
                        viewModel.updateInfo(userInfo = newInfo)
                    },
                    curVisibleState = curVisibleState
                )
                NowPoint(
                    curPoint = curPoint
                )
            }
        }
    )
    // ====================================================================================
}
