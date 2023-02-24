package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class Meeting (
        @SerializedName("id"          ) var id          : String?  = null,
        @SerializedName("title"       ) var title       : String?  = null,
        @SerializedName("description" ) var description : String?  = null,
        @SerializedName("price"       ) var price       : Int?     = null,
        @SerializedName("slots"       ) var slots       : Int?     = null,
        @SerializedName("startAt"     ) var startAt     : String?  = null,
        @SerializedName("endAt"       ) var endAt       : String?  = null,
        @SerializedName("isPrivate"   ) var isPrivate   : Boolean? = null,
        @SerializedName("creatorId"   ) var creatorId   : String?  = null,
        @SerializedName("creator"     ) var creator     : Creator? = Creator()
        )