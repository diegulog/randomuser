package com.diegulog.randomuser.data.remote

import com.diegulog.randomuser.domain.entity.RandomUserResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApiService {
    @GET("/api/")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("results") results: Int,
        @Query("seed") seed: String
    ): Response<RandomUserResponse>
}

fun createApiService(): RandomUserApiService {
    val client = OkHttpClient.Builder()
    val retrofit = Retrofit.Builder()
        .client(client.build())
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(RandomUserApiService::class.java)

}