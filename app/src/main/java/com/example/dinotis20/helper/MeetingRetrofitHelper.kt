package com.example.dinotis20.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MeetingRetrofitHelper {
    val baseUrl = "https://api.hackathon.dinotis.com/v1/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}