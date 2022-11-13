package org.dtree.exercise.data.remote

import org.dtree.exercise.data.local.entity.UserEntity
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    companion object {
        const val BASE_URL = "https://exercise-646d.restdb.io/rest/"
    }

    @Headers("x-apikey: 5c5c7076f210985199db5488")
    @GET("group-1")
    suspend fun getUsers(): List<UserEntity>



}