package com.example.myanime.HomeScreen.data.remote.ApiFields


import com.google.gson.annotations.SerializedName

data class Prop(
    @SerializedName("from")
    val from: From,
    @SerializedName("to")
    val to: To
)