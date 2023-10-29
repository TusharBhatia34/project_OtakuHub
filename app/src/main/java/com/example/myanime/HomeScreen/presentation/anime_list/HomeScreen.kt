@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myanime.HomeScreen.presentation.anime_list


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.animelist.domain.model.Anime
import com.example.animelist.presentation.anime_list.AnimeList
import com.example.myanime.HomeScreen.presentation.AnimeViewModel
import com.example.myanime.HomeScreen.presentation.anime_list.components.filterDialog
import com.example.myanime.HomeScreen.presentation.anime_list.components.searchBar
import com.example.myanime.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(navController: NavController,showDialog:Boolean, anime: LazyPagingItems<Anime>,viewModel: AnimeViewModel) {
    Box(modifier =Modifier.fillMaxSize() .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center){
if (anime.loadState.refresh is LoadState.Loading){
        CircularProgressIndicator(color = MaterialTheme.colorScheme.background)
}
    else{
    Scaffold(
        topBar = {
            TopAppBar(title = {
                              Text(text = "")
            }, actions = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    searchBar(
                        Modifier
                            .weight(3.5f)
                            .padding(10.dp),
                        navController,
                        viewModel
                    )

                    IconButton(
                        onClick = {

                   viewModel.showDialog()
                        },
                        modifier = Modifier
                            .weight(0.5f)
                            .size(30.dp)
                            .padding(end = 8.dp),
                    ) {
                        Icon(painter = painterResource(id = R.drawable.filter), contentDescription = null)
                    }
                }
            })

        }
    ) {
        Column( modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            if (showDialog){

                filterDialog(viewModel)
            }
            AnimeList(anime = anime,navController,viewModel)

        }


    }
}}}