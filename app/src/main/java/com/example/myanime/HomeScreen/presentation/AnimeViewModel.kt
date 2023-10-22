package com.example.myanime.HomeScreen.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.myanime.HomeScreen.Mappers.toAnime
import com.example.myanime.HomeScreen.Mappers.toAnimeEntity
import com.example.myanime.HomeScreen.data.local.AnimeEntity
import com.example.myanime.HomeScreen.presentation.anime_list.AnimeListState

import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AnimeViewModel @Inject constructor(
    pager: Pager<Int, AnimeEntity>
):ViewModel() {

val pagerFlow = pager
                .flow
        .map { pagingData->
            pagingData.map { it.toAnime() }
        }.cachedIn(viewModelScope)
var _state = MutableStateFlow(AnimeListState())
var state = _state.asStateFlow()
    fun showDialog(){
        Log.d("viewmodel", " show dialog() working")
       _state.update {
          it.copy(
              showDialog = true
          )
      }
    }
    fun HideDialog(){
         _state.update {
            it.copy(
                showDialog = false
            )
        }
    }
    fun setName(name:String){
        _state.update {
            it.copy(
                name = name
            )
        }
    }
    fun setContent(
                    name:String,
                    imageUrl:String,
                    totalEps:Int,
                    aired:String?,
                    status:String?,
                    rating:String?,
                    score:Double?,
                    scoreBy: Int?,
                    synopsis:String?,
                    studio:String?,
                    genres:List<String>?
    ){

        _state.update {
            Log.d("missionAnimeInfo","setContentCheck")
            it.copy(
                name = name,
                imageUrl = imageUrl,
                totalEpisodes = totalEps,
                aired = aired,
                status = status,
                rating = rating,
                score = score,
                scoredBy = scoreBy,
                synopsis = synopsis,
                studio = studio,
                genres = genres
            )

        }

    }
}
