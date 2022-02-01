package com.example.recodon.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recodon.data.models.UserInfo

@Database(entities = [UserInfo::class], version = 1, exportSchema = false)
abstract class FeedDatabase: RoomDatabase() {

    abstract fun feedDao(): FeedDao

}