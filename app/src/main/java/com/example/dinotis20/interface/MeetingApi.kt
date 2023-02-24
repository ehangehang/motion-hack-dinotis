package com.example.dinotis20.`interface`

import com.example.dinotis20.model.Meeting
import retrofit2.Response
import retrofit2.http.GET

interface MeetingApi {
    @GET("meetings")
    suspend fun getMeeting(): Response<Meeting>
}