package com.example.myanime.HomeScreen.data.remote


import com.example.animelist.common.Constants

import retrofit2.http.GET
import retrofit2.http.Query

interface jikanApi {
    @GET(Constants.END_POINT)
    suspend fun getAnimeList(
        @Query("order_by")orderBy:String ,
        @Query("type")type:String="tv",
        @Query("sfw") filterAdultContent:Boolean = true,
        @Query("page") currentPage:Int,
        @Query("limit") pageSize:Int,

    ): AnimeDto
     @GET(Constants.END_POINT)
    suspend fun getAnimeSearch(
       @Query("q") query:String,
         @Query("page") currentPage: Int,
         @Query("limit") pageSize:Int=20
    ): AnimeDto
  @GET(Constants.END_POINT)
    suspend fun getAnimeFilter(
       @Query("genres") genres:String,
       @Query("page") currentPage: Int,
       @Query("limit") pageSize:Int=20,
       @Query("order_by")orderBy: String="popularity",
       @Query("genres_exclude")genresExclude:String="9,49,12"
    ): AnimeDto

}