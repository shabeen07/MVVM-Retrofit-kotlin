package com.devcods.mvvm_retrofit_kotlin.api

import com.devcods.mvvm_retrofit_kotlin.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int) : User

}