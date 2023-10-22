package com.example.myanime

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.myanime.HomeScreen.presentation.AnimeViewModel
import com.example.myanime.HomeScreen.presentation.anime_list.homeScreen
import com.example.myanime.ui.theme.MyAnimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAnimeTheme {
                val viewModel = hiltViewModel<AnimeViewModel>()
                val anime = viewModel.pagerFlow.collectAsLazyPagingItems()
                val state by viewModel.state.collectAsState()
                val navController = rememberNavController()
                NavGraph(navController = navController,state.showDialog,anime,viewModel,state)

            }
        }
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAnimeTheme {

    }
}