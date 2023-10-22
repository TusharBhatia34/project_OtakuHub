package com.example.myanime.HomeScreen.data.local


import androidx.room.TypeConverter
import androidx.room.TypeConverters

import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Convertor {
    @TypeConverter
fun fromList(genre:List<String>):String {
       return genre.joinToString(",")
    }
    @TypeConverter
fun toList(genre:String):List<String>
        {
           return genre.split(",")
        }
}