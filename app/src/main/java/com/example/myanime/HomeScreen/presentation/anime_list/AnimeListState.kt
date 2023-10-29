package com.example.myanime.HomeScreen.presentation.anime_list

import android.app.AlertDialog

data class AnimeListState(
    val showDialog: Boolean=false,
    var query:String="",
    val name:String = ""
    , val imageUrl:String? ="",
    val totalEpisodes:Int?=0,
    val aired:String? = "gg",
    val status:String?="",
    val rating:String?="",
    val score:Double?=0.0,
    val scoredBy:Int?=0,
    val synopsis:String?="",
    val studio: String?="",
    val genres:List<String>? = listOf("Action")

)
