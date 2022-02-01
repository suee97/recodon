package com.example.recodon.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.recodon.data.models.UserInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedDao {

    @Query("SELECT * FROM user_info_table ORDER BY id ASC")
    fun getAllInfo(): Flow<List<UserInfo>>

    @Insert
    suspend fun addInfo(userInfo: UserInfo)

    // Point + 1 최대 20
    @Query("UPDATE user_info_table SET point = point + 1 WHERE point < 20")
    suspend fun updatePoint()

    // Point 리셋
    @Query("UPDATE user_info_table SET point = 0")
    suspend fun resetPoint()

    // GoalIndex + 1 최대 1000
    @Query("UPDATE user_info_table SET goalIndex = goalIndex + 3 WHERE goalIndex < 99")
    suspend fun updateGoalIndex()

    // GoalIndex 리셋 to 0
    @Query("UPDATE user_info_table SET goalIndex = 0")
    suspend fun resetGoalIndex()
}