package com.example.myanime.HomeScreen.domain.model

data class SearchAnime(
    val name:String
    ,val imageUrl:String ,
    val totalEpisodes:Int,
    val aired:String?,
    val status:String?,
    val rating:String?,
    val score:Double?,
    val scoredBy:Int?,
    val synopsis:String?,
    val studio: String?,
    val genres:List<String>?
)
