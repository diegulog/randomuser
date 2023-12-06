package com.diegulog.randomuser.data.local.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diegulog.randomuser.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>
    @Query("SELECT * FROM user WHERE email = :email")
    suspend fun get(email: String): UserEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(userEntity: UserEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entities: List<UserEntity>)
}
