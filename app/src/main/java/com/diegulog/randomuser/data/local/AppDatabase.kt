package com.diegulog.randomuser.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diegulog.randomuser.data.local.entity.UserDao
import com.diegulog.randomuser.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1 )
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}