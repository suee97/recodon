package com.example.recodon.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recodon.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class UserInfo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nickName: String,
    val point: Int,
    val goalIndex: Int,
    val visibleState: VisibleState
)
