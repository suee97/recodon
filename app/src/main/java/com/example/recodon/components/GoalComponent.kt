package com.example.recodon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.data.models.VisibleState

// 목표 3개짜리 뷰
@Composable
fun GoalView(
    goalList: List<String>,
    goalIndex: Int,
    onFirstGoalSuccessClicked: () -> Unit,
    onSecondGoalSuccessClicked: () -> Unit,
    onThirdGoalSuccessClicked: () -> Unit,
    curVisibleState: VisibleState
) {
    Box(
        modifier = Modifier
            .fillMaxWidth().height(150.dp).border(2.dp, Color.Magenta)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            GoalComponent(
                goalText = goalList[(goalIndex+3)%goalList.size],
                onSuccessClicked = { onFirstGoalSuccessClicked() },
                onGiveUpClicked = {},
                isVisible = curVisibleState.FIRST_GOAL
            )
            GoalComponent(
                goalText = goalList[(goalIndex+1)%goalList.size],
                onSuccessClicked = { onSecondGoalSuccessClicked() },
                onGiveUpClicked = {},
                isVisible = curVisibleState.SECOND_GOAL
            )
            GoalComponent(
                goalText = goalList[(goalIndex+2)%goalList.size],
                onSuccessClicked = { onThirdGoalSuccessClicked() },
                onGiveUpClicked = {},
                isVisible = curVisibleState.THIRD_GOAL
            )
        }
    }
}

// 목표 한 개짜리 컴포넌트
@Composable
fun GoalComponent(
    goalText: String,
    onSuccessClicked: () -> Unit,
    onGiveUpClicked: () -> Unit,
    isVisible: Boolean
) {
    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
                Button(onClick = { onSuccessClicked() }) {
                    Text("완료")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { onGiveUpClicked() }) {
                    Text("포기")
                }
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
                    fontSize = 20.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}
