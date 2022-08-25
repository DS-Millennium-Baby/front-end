package com.example.millennium_baby

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication {
    companion object {

        // OkHttpClient
        var client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor()).build()

        /* 요청 IP */
        val apiserver = "http://192.168.0.19:5000/"
        //172.18.32.225 대강의실 IP
        // 192.168.0.23 해커톤2

        // api/users
        var networkServiceUsers: NetworkServiceUsers
        val retrofitUsers: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(apiserver + "api/users/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // api/majors
        val networkServiceMajors : NetworkServiceMajors
        val retrofitMajors : Retrofit
            get() = Retrofit.Builder()
                .baseUrl(apiserver + "api/majors/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // api/questions
        val networkServiceQuestions : NetworkServiceQuestion
        val retrofitQuestion : Retrofit
            get() = Retrofit.Builder()
                .baseUrl(apiserver + "api/questions/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // api/answers
        val networkServiceAnswers : NetworkServiceAnswer
        val retrofitAnswer : Retrofit
            get() = Retrofit.Builder()
                .baseUrl(apiserver + "api/answers/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // api/tips
        val networkServiceTips : NetworkServiceTip
        val retrofitTip : Retrofit
            get() = Retrofit.Builder()
                .baseUrl(apiserver + "api/tips/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // api/comments
        val networkServiceComments : NetworkServiceComment
        val retrofitComment : Retrofit
            get() = Retrofit.Builder()
                .baseUrl(apiserver + "api/comments/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        init{
            networkServiceUsers = retrofitUsers.create(NetworkServiceUsers::class.java)  // api/users/
            networkServiceMajors = retrofitMajors.create(NetworkServiceMajors::class.java) // api/majors/
            networkServiceQuestions = retrofitQuestion.create(NetworkServiceQuestion::class.java) // api/questions/
            networkServiceAnswers = retrofitAnswer.create(NetworkServiceAnswer::class.java) // api/answers
            networkServiceTips = retrofitTip.create(NetworkServiceTip::class.java) // api/tips
            networkServiceComments = retrofitComment.create(NetworkServiceComment::class.java) // api/comments
        }


        private fun httpLoggingInterceptor(): HttpLoggingInterceptor? {
            val interceptor = HttpLoggingInterceptor { message ->
                Log.e(
                    "mobileApp :",
                    message + ""
                )
            }
            return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }
}