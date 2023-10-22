package com.example.animelist.presentation.anime_list.components

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.room.Entity
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.data.local.AnimeEntity
import com.example.myanime.HomeScreen.presentation.AnimeViewModel

import kotlinx.coroutines.delay

@Composable
fun customAnimeBox(anime:Anime ,navController:NavController,viewModel: AnimeViewModel) {


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
@Composable
fun customAnimeBox2(text:String,imageUrl:String) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
        Box(modifier = Modifier
            .size(200.dp, 200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .clip(RoundedCornerShape(20.dp))){
            AsyncImage( contentScale = ContentScale.FillBounds
                ,modifier = Modifier.fillMaxSize()

                   , model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .build()
                , contentDescription = null,
                )
            Text(text = text, modifier = Modifier.align(Alignment.TopCenter))
        }





//    }

}

@Preview
@Composable
fun dj() {
    customAnimeBox2(text = "image", imageUrl ="" )
}

