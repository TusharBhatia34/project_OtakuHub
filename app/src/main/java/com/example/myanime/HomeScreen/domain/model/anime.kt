package com.example.animelist.domain.model





data class Anime(
    val name:String
    ,val imageUrl:String? ,
    val totalEpisodes:Int?,
    val aired:String?,
    val status:String?,
    val rating:String?,
    val score:Double?,
    val scoredBy:Int?,
    val synopsis:String?,
    val studio: String?,
 val genres:List<String>?
)
