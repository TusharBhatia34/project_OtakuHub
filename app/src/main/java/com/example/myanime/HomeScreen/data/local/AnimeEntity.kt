package com.example.myanime.HomeScreen.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animeList")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String
    ,val imageUrl:String?
    ,val totalEpisodes:Int?,
    val aired:String?,
    val status:String?,
    val rating:String?,
    val score:Double?,
    val scoredBy:Int?,
    val synopsis:String?,
    var studio: String?,
  val genres:List<String>?
)
