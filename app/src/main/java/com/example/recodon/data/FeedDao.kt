package com.example.recodon.data

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

    @Update
    suspend fun updateInfo(userInfo: UserInfo)
}