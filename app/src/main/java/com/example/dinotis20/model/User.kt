package com.example.dinotis20.model

data class User (
        var email: String,
        var name: String,
        var profPic: String = "",
        var roles: List<String> = emptyList(),
        var verif: Boolean = false
        )