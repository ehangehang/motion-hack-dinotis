package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class ResponseListMeetings(
    @SerializedName("metadata")
    var metadata: Metadata,
    @SerializedName("meetings")
    var meetings: List<Meeting>
)
