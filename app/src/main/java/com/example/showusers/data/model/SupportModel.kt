package com.example.showusers.data.model


import com.google.gson.annotations.SerializedName

data class SupportModel(
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("url")
    val url: String? = ""
)