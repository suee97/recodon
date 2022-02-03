package com.example.recodon.components

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
    onFirstGoalSuccessClicked: () -> Unit,
    onSecondGoalSuccessClicked: () -> Unit,
    onThirdGoalSuccessClicked: () -> Unit,
    viewModel: FeedEarthViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(2.dp, Color.Magenta)
    ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
            ) {
                if (viewModel.curPoint < 20) {
                    GoalComponent(
                        goalText = goalList[(viewModel.goalIndex + 3) % goalList.size],
                        onSuccessClicked = { onFirstGoalSuccessClicked() },
                        isVisible = viewModel.curVisibleState.FIRST_GOAL
                    )
                    GoalComponent(
                        goalText = goalList[(viewModel.goalIndex + 1) % goalList.size],
                        onSuccessClicked = { onSecondGoalSuccessClicked() },
                        isVisible = viewModel.curVisibleState.SECOND_GOAL
                    )
                    GoalComponent(
                        goalText = goalList[(viewModel.goalIndex + 2) % goalList.size],
                        onSuccessClicked = { onThirdGoalSuccessClicked() },
                        isVisible = viewModel.curVisibleState.THIRD_GOAL
                    )
                } else {
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
    onSuccessClicked: () -> Unit,
    isVisible: Boolean
) {
    if (isVisible) {

        // Swipe
        val swipeState = rememberDismissState(
            confirmStateChange = {
                if (it == DismissValue.DismissedToStart) {
                    onSuccessClicked()
                }
                true
            }
        )

        SwipeToDismiss(
            state = swipeState,
            background = {},
            dismissContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .padding(vertical = 4.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(6.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = 4.dp),
                            text = goalText,
                            fontSize = 20.sp
                        )
                    }
                }
            },
            directions = setOf(DismissDirection.EndToStart)
        )
    }
}
