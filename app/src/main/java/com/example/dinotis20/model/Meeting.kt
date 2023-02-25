package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class Meeting (
    @SerializedName("id"          ) var id          : String,
    @SerializedName("title"       ) var title       : String,
    @SerializedName("description" ) var description : String,
    @SerializedName("price"       ) var price       : Int,
    @SerializedName("slots"       ) var slots       : Int,
    @SerializedName("startAt"     ) var startAt     : String,
    @SerializedName("endAt"       ) var endAt       : String,
    @SerializedName("isPrivate"   ) var isPrivate   : Boolean,
    @SerializedName("creatorId"   ) var creatorId   : String,
    @SerializedName("creator"     ) var creator     : Creator
        )