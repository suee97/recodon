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

    // Point 리셋
    @Query("UPDATE user_info_table SET point = 0")
    suspend fun resetPoint()

    // VisibleState 초기화 to (true, true, true)
    @Update
    suspend fun updateInfo(userInfo: UserInfo)
}