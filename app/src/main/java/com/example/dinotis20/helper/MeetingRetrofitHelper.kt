package com.example.dinotis20.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MeetingRetrofitHelper {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.hackathon.dinotis.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}