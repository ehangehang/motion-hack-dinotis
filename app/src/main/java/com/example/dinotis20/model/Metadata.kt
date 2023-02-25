package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("page")
    var page : Int,
    @SerializedName("size")
    var size : Int,
    @SerializedName("total")
    var total : Int,
    @SerializedName("totalPage")
    var totalPage : Int
)
