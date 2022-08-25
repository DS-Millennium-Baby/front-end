package com.example.millennium_baby

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkServiceQuestion {
    @GET("getQuestionThree/{major}")
    fun displayQuestionThree(
        @Path("major") question: String
    ): Call<QuestionThreeListRes>

    @GET("getQuestion/{major}")
    fun displayQuestion(
        @Path("major") question: String
    ): Call<QuestionListRes>

    @GET("{questionID}")
    fun detailQuestion(
        @Path("questionID") question: String
    ): Call<QuestionDetailRes>

    @POST("addQuestion")
    fun addQuestion(
        @Body question: AddQuestionReq,
    ): Call<AddQuestionRes>
}

data class QuestionListRes(val success: String, val message: String, val title: String,
                           val content: String, val major: String, val writer: String)
data class QuestionThreeListRes(val success: String, val message: String, val title: String, val major: String)
data class QuestionDetailRes(val success: String, val message: String, val title: String,
                             val content: String, val category: String, val major: String, val writer: String)
data class AddQuestionReq(val title: String, val content: String, val category: String,
                          val major: String, val writer: String)
data class AddQuestionRes(val success: String, val message: String)