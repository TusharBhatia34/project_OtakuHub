package com.example.myanime.HomeScreen.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert



@Dao
interface AnimeDao {
    @Upsert
    suspend fun upsertAll(animeEntity: List<AnimeEntity>)

    @Query("SELECT * FROM animeList")
    fun pagingSource():PagingSource<Int,AnimeEntity>



}