package com.example.myanime.HomeScreen.Mappers

import com.example.myanime.HomeScreen.data.local.AnimeEntity
import com.example.myanime.HomeScreen.data.remote.ApiFields.Data


fun Data.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(

        name = titles[0].title,
        imageUrl = images.jpg.imageUrl,
        totalEpisodes = episodes,
        aired = aired.string,
        status = status,
        rating = rating,
        score = score,
        scoredBy = scoredBy,
        synopsis = synopsis,
        studio = studios[0].name,
        genres = genres.map { genre -> genre.name }

    )
}