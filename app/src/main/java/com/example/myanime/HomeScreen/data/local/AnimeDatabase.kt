package com.example.myanime.HomeScreen.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import retrofit2.Converter



@Database(
    entities = [AnimeEntity::class],
    version = 1
)
@TypeConverters(Convertor::class)
abstract class AnimeDatabase:RoomDatabase() {
    abstract val dao:AnimeDao
}