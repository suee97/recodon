package com.example.recodon.data.repositories

import com.example.recodon.data.FeedDao
import com.example.recodon.data.models.UserInfo
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class FeedEarthRepository @Inject constructor(
    private val feedDao: FeedDao
) {

    val getAllInfo: Flow<List<UserInfo>> = feedDao.getAllInfo()

    suspend fun addInfo(userInfo: UserInfo) {
        feedDao.addInfo(userInfo = userInfo)
    }

    suspend fun updateInfo(userInfo: UserInfo) {
        feedDao.updateInfo(userInfo = userInfo)
    }

}