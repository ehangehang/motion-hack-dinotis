package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class Profession (
    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null
        )
