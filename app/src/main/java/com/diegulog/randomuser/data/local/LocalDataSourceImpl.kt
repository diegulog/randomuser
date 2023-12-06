package com.diegulog.randomuser.data.local

import com.diegulog.randomuser.data.local.entity.UserEntity
import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.domain.repository.local.LocalDataSource

class LocalDataSourceImpl(private val appDatabase: AppDatabase) : LocalDataSource {
    override suspend fun getUsers(): List<User> {
        return appDatabase.userDao().getAll().map { it.toDomain() }
    }

    override suspend fun saveUser(user: User) {
        appDatabase.userDao().save(UserEntity.fromDomain(user))
    }

    override suspend fun saveUser(users: List<User>) {
        appDatabase.userDao().save(users.map {UserEntity.fromDomain(it)})

    }
}