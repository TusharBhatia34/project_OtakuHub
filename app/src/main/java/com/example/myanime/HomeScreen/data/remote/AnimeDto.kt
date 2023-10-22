package com.example.myanime.HomeScreen.data.remote


import com.example.myanime.HomeScreen.data.remote.ApiFields.Data
import com.example.myanime.HomeScreen.data.remote.ApiFields.Pagination

import com.google.gson.annotations.SerializedName

data class AnimeDto(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination
)