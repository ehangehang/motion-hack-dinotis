package com.example.dinotis20.`interface`

import com.example.dinotis20.model.ResponseListCreators
import com.example.dinotis20.model.ResponseListMeetings
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("meetings")
    suspend fun getMeeting(): Response<ResponseListMeetings>
    @GET("meetings")
    suspend fun getMeeting(@Query("size") size : Int): Response<ResponseListMeetings>
    @GET("creators")
    suspend fun getCreators(): Response<ResponseListCreators>
    @GET("creators")
    suspend fun getCreators(@Query("q") q : String) : Response<ResponseListCreators>
}