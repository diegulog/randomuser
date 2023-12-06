package com.diegulog.randomuser.data.remote

import com.diegulog.randomuser.domain.entity.User
import com.diegulog.randomuser.domain.repository.remote.ApiException
import com.diegulog.randomuser.domain.repository.remote.NetworkDataSource
import com.diegulog.randomuser.domain.repository.remote.NetworkException
import org.json.JSONObject
import java.io.IOException

class NetworkDataSourceImpl(private val randomUserApiService: RandomUserApiService) :
    NetworkDataSource {

    @Throws(IOException::class)
    override suspend fun getUsers(page: Int, results: Int, seed: String): List<User> {
        try {
            val response = randomUserApiService.getUsers(page, results, seed)
            if (response.isSuccessful) {
                return response.body()?.results ?: emptyList()
            } else {
                response.errorBody()?.let {
                    val jsonObject = JSONObject(it.string())
                    val error = jsonObject.getString("error")
                    throw ApiException(error)
                }
                throw ApiException("Error connecting to server. Please try again later. Code: ${response.code()}")
            }
        } catch (ioe: IOException) {
            throw NetworkException()
        }
    }
}