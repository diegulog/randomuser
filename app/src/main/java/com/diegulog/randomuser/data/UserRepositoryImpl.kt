package com.diegulog.randomuser.data

import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.domain.repository.UserRepository
import com.diegulog.randomuser.domain.repository.local.LocalDataSource
import com.diegulog.randomuser.domain.repository.remote.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class UserRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
) : UserRepository {
    override fun getUsers(
        page: Int,
        results: Int,
        seed: String
    ): Flow<ResultOf<List<User>>> = flow {
        emit(ResultOf.Loading)
        val cache = localDataSource.getUsers()
        if(cache.isNotEmpty()){
            emit(ResultOf.Success(cache))
        }
        try {
            val users = networkDataSource.getUsers(page, results, seed)
            localDataSource.saveUser(users)
            emit(ResultOf.Success(localDataSource.getUsers()))
        } catch (e: IOException) {
            emit(ResultOf.Failure(e))
        }
    }
}