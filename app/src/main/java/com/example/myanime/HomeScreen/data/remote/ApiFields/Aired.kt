package com.example.myanime.HomeScreen.data.remote.ApiFields


import com.google.gson.annotations.SerializedName

data class Aired(
    @SerializedName("from")
    val from: String,
    @SerializedName("prop")
    val prop: Prop,
    @SerializedName("string")
    val string: String,
    @SerializedName("to")
    val to: String
)