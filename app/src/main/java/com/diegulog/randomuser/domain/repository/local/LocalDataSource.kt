package com.diegulog.randomuser.domain.repository.local

import com.diegulog.randomuser.domain.entity.User

interface LocalDataSource {
    suspend fun getUsers(): List<User>
    suspend fun saveUser(user: User)
    suspend fun saveUser(user: List<User>)
}