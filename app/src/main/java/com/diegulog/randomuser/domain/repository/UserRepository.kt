package com.diegulog.randomuser.domain.repository

import com.diegulog.randomuser.data.ResultOf
import com.diegulog.randomuser.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(
        page: Int,
        results: Int,
        seed: String
    ): Flow<ResultOf<List<User>>>
}