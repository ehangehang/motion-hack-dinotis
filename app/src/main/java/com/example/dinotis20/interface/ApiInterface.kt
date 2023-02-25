package com.example.dinotis20.`interface`

import com.example.dinotis20.model.ResponseListMeetings
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("meetings")
    suspend fun getMeeting(): Response<ResponseListMeetings>
}