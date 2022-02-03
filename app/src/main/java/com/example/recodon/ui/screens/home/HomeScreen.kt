package com.example.recodon.ui.screens.home

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recodon.R
import com.example.recodon.components.*
import com.example.recodon.data.models.UserInfo
import com.example.recodon.data.models.VisibleState
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import com.example.recodon.ui.theme.StatusColor
import com.example.recodon.utils.Constants.goalList
import com.example.recodon.utils.RequestState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    viewModel: FeedEarthViewModel
) {

    // Fetch & Update Data =========================================================================
    LaunchedEffect(key1 = true) {
        viewModel.getAllInfo()
    }

    val allInfos by viewModel.allInfo.collectAsState()

    if (allInfos is RequestState.Success) {
        // 데이터 비어있을 때, 초기 실행 시 초기화
        if ((allInfos as RequestState.Success<List<UserInfo>>).data.isEmpty()) {
            val emptyInfo = UserInfo(
                1,
                "nick_name",
                0,
                0,
                VisibleState.STATE_111
            )
            viewModel.addInfo(userInfo = emptyInfo)
            viewModel.curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point
            viewModel.goalIndex = (allInfos as RequestState.Success<List<UserInfo>>).data[0].goalIndex
            viewModel.curVisibleState =
                (allInfos as RequestState.Success<List<UserInfo>>).data[0].visibleState
        } else {
            // 모든 데이터 로그
            Log.d(
                "suee97", "allInfos => " +
                        "${(allInfos as RequestState.Success<List<UserInfo>>).data[0]}"
            )
            viewModel.curPoint = (allInfos as RequestState.Success<List<UserInfo>>).data[0].point
            viewModel.goalIndex = (allInfos as RequestState.Success<List<UserInfo>>).data[0].goalIndex
            viewModel.curVisibleState =
                (allInfos as RequestState.Success<List<UserInfo>>).data[0].visibleState
        }
    }
    // =====================================================================================


    // View ================================================================================
    val systemUiController = rememberSystemUiController() // 상단 바 색상 조정
    systemUiController.setSystemBarsColor(color = StatusColor)

    Box() {
        AnimationView(curPoint = viewModel.curPoint)
    }
    
    Scaffold(
        backgroundColor = Color.Transparent,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp) // 모든 Content 에 대한 padding
            ) {

                TodolistMsg(msg = "오늘의 목표")

                GoalView(
                    onFirstGoalSuccessClicked = {
                        if(viewModel.curPoint < 20) {
                            when (viewModel.curVisibleState) {
                                VisibleState.STATE_111 -> viewModel.curVisibleState = VisibleState.STATE_011
                                VisibleState.STATE_110 -> viewModel.curVisibleState = VisibleState.STATE_010
                                VisibleState.STATE_101 -> viewModel.curVisibleState = VisibleState.STATE_001
                                VisibleState.STATE_100 -> viewModel.curVisibleState = VisibleState.STATE_000
                            }
                            viewModel.updateInfo()
                        }
                    },
                    onSecondGoalSuccessClicked = {
                        if(viewModel.curPoint < 20) {
                            when (viewModel.curVisibleState) {
                                VisibleState.STATE_111 -> viewModel.curVisibleState = VisibleState.STATE_101
                                VisibleState.STATE_110 -> viewModel.curVisibleState = VisibleState.STATE_100
                                VisibleState.STATE_011 -> viewModel.curVisibleState = VisibleState.STATE_001
                                VisibleState.STATE_010 -> viewModel.curVisibleState = VisibleState.STATE_000
                            }
                            viewModel.updateInfo()
                        }
                    },
                    onThirdGoalSuccessClicked = {
                        if(viewModel.curPoint < 20) {
                            when (viewModel.curVisibleState) {
                                VisibleState.STATE_111 -> viewModel.curVisibleState = VisibleState.STATE_110
                                VisibleState.STATE_101 -> viewModel.curVisibleState = VisibleState.STATE_100
                                VisibleState.STATE_011 -> viewModel.curVisibleState = VisibleState.STATE_010
                                VisibleState.STATE_001 -> viewModel.curVisibleState = VisibleState.STATE_000
                            }
                            viewModel.updateInfo()
                        }
                    },
                    viewModel = viewModel
                )

                NowPoint(viewModel = viewModel)

                GoalResetButton(
                    onClick = {
                        if (viewModel.goalIndex >= 99) {
                            val newInfo = UserInfo(
                                1,
                                "nick_name",
                                viewModel.curPoint,
                                0,
                                VisibleState.STATE_111
                            )
                            viewModel.updateInfo(userInfo = newInfo)
                        } else {
                            val newInfo = UserInfo(
                                1,
                                "nick_name",
                                viewModel.curPoint,
                                viewModel.goalIndex + 3,
                                VisibleState.STATE_111
                            )
                            viewModel.updateInfo(userInfo = newInfo)
                        }
                    }
                )

                PointResetButton(onClick = {
                    viewModel.curVisibleState = VisibleState.STATE_111
                    val newInfo = UserInfo(
                        1,
                        "nick_name",
                        0,
                        viewModel.goalIndex,
                        VisibleState.STATE_111
                    )
                    viewModel.updateInfo(userInfo = newInfo)
                })
            }
        }
    )
    // ====================================================================================
}
