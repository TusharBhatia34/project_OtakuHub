package com.example.myanime.HomeScreen.presentation.anime_search

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.domain.model.SearchAnime
import com.example.myanime.HomeScreen.presentation.AnimeViewModel

@Composable
fun searchAnimeList(
    anime: LazyPagingItems<SearchAnime>,
    navController: NavController,
    viewModel: AnimeViewModel
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = anime.loadState) {
        if(anime.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (anime.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(anime.itemCount) { index ->
                anime[index]?.let {
                     searchCustomAnimeBox(anime = it,navController,viewModel)
                }
            }
        }
    }
}