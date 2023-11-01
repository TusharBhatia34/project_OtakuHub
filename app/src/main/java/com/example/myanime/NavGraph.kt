package com.example.myanime

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.LazyPagingItems
import com.example.animelist.common.Constants
import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.presentation.AnimeViewModel
import com.example.myanime.HomeScreen.presentation.anime_info.animeInfoScreen
import com.example.myanime.HomeScreen.presentation.AnimeListState
import com.example.myanime.HomeScreen.presentation.anime_filter.filterResultScreen
import com.example.myanime.HomeScreen.presentation.anime_list.homeScreen
import com.example.myanime.HomeScreen.presentation.anime_search.searchResultScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    showDialog: Boolean,
    anime:LazyPagingItems<Anime>,
    viewModel: AnimeViewModel,
    searchAnime:LazyPagingItems<Anime>,
    state: AnimeListState,
    filterAnime:LazyPagingItems<Anime>
) {

    NavHost(navController = navController , startDestination = Constants.HOME_SCREEN_ROUTE ){
        composable(route = Constants.HOME_SCREEN_ROUTE){
            homeScreen(
                navController = navController,
                showDialog = showDialog,
                anime = anime,
                viewModel = viewModel
            )
        }
        composable(route = Constants.ANIME_INFO_ROUTE ){
            animeInfoScreen(
                navController = navController,
                state = state,

            )
        }
        composable(route = Constants.SEARCH_ANIME_ROUTE ){
           searchResultScreen(
               navController = navController,
             searchAnime = searchAnime,
               state = state,
               viewModel = viewModel
           )
        }
        composable(route = Constants.FILTER_ANIME_ROUTE ){
           filterResultScreen(
               navController = navController,
             filterAnime = filterAnime,
               state = state,
               viewModel = viewModel
           )
        }
    }
}