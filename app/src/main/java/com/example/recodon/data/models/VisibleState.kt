package com.example.recodon.data.models

enum class VisibleState(
    var FIRST_GOAL: Boolean,
    val SECOND_GOAL: Boolean,
    val THIRD_GOAL: Boolean
)
{
    STATE_111(true, true, true),
    STATE_110(true, true, false),
    STATE_101(true, false, true),
    STATE_011(false, true, true),
    STATE_100(true, false, false),
    STATE_001(false, false, true),
    STATE_010(false, true, false),
    STATE_000(false, false, false)
}