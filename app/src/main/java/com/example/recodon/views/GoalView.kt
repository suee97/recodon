package com.example.recodon.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.data.models.VisibleState
import com.example.recodon.data.viewmodels.FeedEarthViewModel
import com.example.recodon.utils.Constants.goalList

// 목표 3개짜리 뷰
@ExperimentalMaterialApi
@Composable
fun GoalView(
    onFirstGoalSwiped: () -> Unit,
    onSecondGoalSwiped: () -> Unit,
    onThirdGoalSwiped: () -> Unit,
    onGoalResetClicked: () -> Unit,
    viewModel: FeedEarthViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .border(2.dp, Color.Magenta)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            if (viewModel.curPoint < 20) {
                if (viewModel.curVisibleState == VisibleState.STATE_000) {

                    // 하루 목표 3개 모두 끝냈을 때
                    EmptyVisibleState(
                        viewModel = viewModel,
                        onClick = { onGoalResetClicked() }
                    )

                } else {
                    GoalComponent(
                        goalText = goalList[(viewModel.goalIndex + 3) % goalList.size],
                        onSwiped = { onFirstGoalSwiped() },
                        isVisible = viewModel.curVisibleState.FIRST_GOAL
                    )
                    GoalComponent(
                        goalText = goalList[(viewModel.goalIndex + 1) % goalList.size],
                        onSwiped = { onSecondGoalSwiped() },
                        isVisible = viewModel.curVisibleState.SECOND_GOAL
                    )
                    GoalComponent(
                        goalText = goalList[(viewModel.goalIndex + 2) % goalList.size],
                        onSwiped = { onThirdGoalSwiped() },
                        isVisible = viewModel.curVisibleState.THIRD_GOAL
                    )
                }
            } else {
                // 포인트 20 도달했을 때
                Text("임무 완수", fontSize = 20.sp)
            }
        }

    }
}

// 목표 한 개짜리 컴포넌트
@ExperimentalMaterialApi
@Composable
fun GoalComponent(
    goalText: String,
    onSwiped: () -> Unit,
    isVisible: Boolean
) {
    if (isVisible) {

        // Swipe
        val swipeState = rememberDismissState(
            confirmStateChange = {
                if (it == DismissValue.DismissedToStart) {
                    onSwiped()
                }
                true
            }
        )

        SwipeToDismiss(
            state = swipeState,
            background = {},
            dismissContent = {
                Card(
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RoundedCornerShape(4.dp),
                    elevation = 8.dp,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Row() {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            text = goalText,
                            fontSize = 23.sp,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
            },
            directions = setOf(DismissDirection.EndToStart)
        )
    }
}
