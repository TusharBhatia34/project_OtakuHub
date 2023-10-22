package com.example.myanime.HomeScreen.Mappers

import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.data.local.AnimeEntity

fun AnimeEntity.toAnime():Anime{
    return Anime(
        id = id,
        name = name,
        imageUrl = imageUrl,
        totalEpisodes = totalEpisodes,
        aired = aired,
        status = status,
        rating = rating,
        score = score,
        scoredBy = scoredBy,
        synopsis = synopsis,
        studio = studio,
        genres = genres
    )
}