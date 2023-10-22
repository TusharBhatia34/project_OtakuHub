package com.example.myanime.HomeScreen.data.remote.ApiFields


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String,

)