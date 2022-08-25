package com.example.millennium_baby

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkServiceUsers {
    @POST("register")
    fun register(
        @Body user: RegisterReq,
    ): Call<RegisterRes>

    @POST("login")
    fun login(
        @Body user: LoginReq,
    ): Call<LoginRes>

}

data class RegisterReq(val name: String, val email: String, val password: String, val firstMajor: String, val secondMajor: String?)
data class RegisterRes(val success: String)

data class LoginReq(val email: String, val password: String)
data class LoginRes(val loginSuccess: String, val userID: String, val userName: String, val firstMajor: String, val secondMajor: String)