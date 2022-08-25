package com.example.millennium_baby

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkServiceMajors {
    @GET("getMajor/{major}")
    fun displayMajor(
        @Path("major") major: String
    ): Call<MajorRes>
}

data class MajorRes(val success: String, val message: String, val majorName: String, val intro: String, val graduate: String )