package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class ResponseListCreators(
    @SerializedName("metadata")
    var metadata: Metadata,
    @SerializedName("creators")
    var creators: List<Creator>
)
