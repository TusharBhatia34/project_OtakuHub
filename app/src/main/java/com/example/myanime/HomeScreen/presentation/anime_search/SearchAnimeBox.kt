package com.example.myanime.HomeScreen.presentation.anime_search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.domain.model.SearchAnime
import com.example.myanime.HomeScreen.presentation.AnimeViewModel

@Composable
fun searchCustomAnimeBox(anime: SearchAnime, navController: NavController, viewModel: AnimeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .size(200.dp, 250.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.onSecondary)

            .clickable {
                viewModel.setContent(
                    name = anime.name,
                    imageUrl = anime.imageUrl,
                    totalEps = anime.totalEpisodes,
                    aired = anime.aired,
                    status = anime.status,
                    rating = anime.rating,
                    score = anime.score,
                    scoreBy = anime.scoredBy,
                    synopsis = anime.synopsis,
                    studio = anime.studio,
                    genres = anime.genres,
                )
                navController.navigate("animeInfoScreen")
            }){
            AsyncImage( contentScale = ContentScale.FillBounds
                ,modifier = Modifier.fillMaxSize()

                , model = ImageRequest.Builder(LocalContext.current)
                    .data(anime.imageUrl)
                    .build()
                , contentDescription = null,

                )
        }
        Text(text = anime.name, overflow = TextOverflow.Ellipsis, maxLines = 1, color = MaterialTheme.colorScheme.onSecondary)
    }

}