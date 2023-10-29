package com.example.myanime.HomeScreen.presentation

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.myanime.HomeScreen.Mappers.toAnime
import com.example.myanime.HomeScreen.data.local.AnimeEntity
import com.example.myanime.HomeScreen.data.remote.SearchPagingSource
import com.example.myanime.HomeScreen.data.remote.jikanApi
import com.example.myanime.HomeScreen.domain.model.SearchAnime
import com.example.myanime.HomeScreen.presentation.anime_list.AnimeListState

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AnimeViewModel @Inject constructor(
    pager: Pager<Int, AnimeEntity>,
   val jikanApi: jikanApi
):ViewModel() {

    private val _state = MutableStateFlow(AnimeListState())
    val state = _state.asStateFlow()


val pagerFlow = pager
                .flow
        .map { pagingData->
            pagingData.map { it.toAnime() }
        }.cachedIn(viewModelScope)

private val _searchFlow= MutableStateFlow<PagingData<SearchAnime>>(PagingData.empty())
    val searchFlow = _searchFlow.asStateFlow()
 private fun flow(){
viewModelScope.launch {

    Pager(PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            SearchPagingSource(jikanApi = jikanApi, query = state.value.query)
        }).flow.cachedIn(viewModelScope).collect{

            _searchFlow.value=it
    }
}
    }

    fun showDialog(){
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
    fun setQuery(query:String){
        _state.update {
            it.copy(
                query = query
            )
        }
            flow()

    }
    fun setContent(
                    name:String,
                    imageUrl:String?,
                    totalEps:Int?,
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
