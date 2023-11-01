@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myanime.HomeScreen.presentation.anime_filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.animelist.domain.model.Anime
import com.example.animelist.presentation.anime_list.animeList
import com.example.myanime.HomeScreen.presentation.AnimeViewModel
import com.example.myanime.HomeScreen.presentation.AnimeListState


@Composable
fun filterResultScreen(
    navController: NavController,
    filterAnime:LazyPagingItems<Anime>,
    state: AnimeListState
    , viewModel: AnimeViewModel
) {

Scaffold(
    topBar = {
        TopAppBar(title = {Text(text = "")}, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null , tint = MaterialTheme.colorScheme.onSecondary)
            }
        }
        , colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ) )
    },
) {
Column(modifier = Modifier
    .fillMaxSize()
    .background(MaterialTheme.colorScheme.primary)
    .padding(it)
    , verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
    if (filterAnime.loadState.refresh is LoadState.Loading){
        CircularProgressIndicator(color = MaterialTheme.colorScheme.background)
    } 
    else if (filterAnime.itemCount==0){
        Text(
            text = "No results found!",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
    else{
        animeList(anime = filterAnime ,navController = navController, viewModel = viewModel)
    }
}
}
}