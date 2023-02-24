package com.example.dinotis20.model

import com.google.gson.annotations.SerializedName

data class Creator (
    @SerializedName("id"          ) var id          : String?                = null,
    @SerializedName("name"        ) var name        : String?                = null,
    @SerializedName("username"    ) var username    : String?                = null,
    @SerializedName("profilPhoto" ) var profilPhoto : String?                = null,
    @SerializedName("isVerified"  ) var isVerified  : Boolean?               = null,
    @SerializedName("professions" ) var professions : ArrayList<Professions> = arrayListOf()
        )
