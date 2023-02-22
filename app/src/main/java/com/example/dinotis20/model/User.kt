package com.example.dinotis20.model

data class User (
        var phoneNumber: String,
        var name: String,
        var profPic: String = "",
        var roles: List<String> = emptyList(),
        var verif: Boolean = false
        )