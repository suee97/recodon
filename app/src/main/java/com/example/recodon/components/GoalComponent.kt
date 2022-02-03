package com.example.recodon.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recodon.data.models.VisibleState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

// 목표 3개짜리 뷰
@ExperimentalAnimationApi
@ExperimentalMaterialApi
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
            .fillMaxWidth()
            .height(150.dp)
            .border(2.dp, Color.Magenta)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            GoalComponent(
                goalText = goalList[(goalIndex + 3) % goalList.size],
                onSuccessClicked = { onFirstGoalSuccessClicked() },
                isVisible = curVisibleState.FIRST_GOAL
            )
            GoalComponent(
                goalText = goalList[(goalIndex + 1) % goalList.size],
                onSuccessClicked = { onSecondGoalSuccessClicked() },
                isVisible = curVisibleState.SECOND_GOAL
            )
            GoalComponent(
                goalText = goalList[(goalIndex + 2) % goalList.size],
                onSuccessClicked = { onThirdGoalSuccessClicked() },
                isVisible = curVisibleState.THIRD_GOAL
            )
        }
    }
}

// 목표 한 개짜리 컴포넌트
@ExperimentalAnimationApi
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
    } else {
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
                    text = "완료된 목표입니다 !",
                    fontSize = 20.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}
