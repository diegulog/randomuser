package com.diegulog.randomuser.domain.repository.remote

import com.diegulog.randomuser.domain.entity.User
import java.io.IOException

interface NetworkDataSource {

    @Throws(IOException::class)
    suspend fun getUsers(
        page: Int,
        results: Int,
        seed: String
    ): List<User>

}