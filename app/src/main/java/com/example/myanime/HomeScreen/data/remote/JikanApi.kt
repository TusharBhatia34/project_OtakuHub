package com.example.myanime.HomeScreen.data.remote


import com.example.animelist.common.Constants

import retrofit2.http.GET
import retrofit2.http.Query

interface jikanApi {
    @GET(Constants.END_POINT)
    suspend fun getAnimeList(
        @Query("page") currentPage:Int,
        @Query("limit") pageSize:Int,
        @Query("sfw") filterAdultContent:Boolean = true,
        @Query("order_by")orderBy:String = "popularity",
        @Query("type")type:String="tv"
    ): AnimeDto
}