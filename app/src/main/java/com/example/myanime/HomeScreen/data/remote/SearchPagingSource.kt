package com.example.myanime.HomeScreen.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animelist.common.Constants
import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.Mappers.toAnime
import com.example.myanime.HomeScreen.Mappers.toSearchAnime
import com.example.myanime.HomeScreen.data.remote.ApiFields.Studio
import com.example.myanime.HomeScreen.domain.model.SearchAnime
import kotlinx.coroutines.delay

class SearchPagingSource(
    val jikanApi: jikanApi,
    val query:String
): PagingSource<Int, SearchAnime>() {
    override fun getRefreshKey(state: PagingState<Int, SearchAnime>): Int {
       return Constants.key
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchAnime> {
 return try {
    val nextPage=params.key?:1
     delay(2000L)
    val searchResult = jikanApi.getAnimeSearch(
        query = query ,
        currentPage = nextPage,
    )
    Constants.key = searchResult.pagination.currentPage+1
    val searchList= searchResult.data.map {
        if(it.studios.isEmpty()){
            it.studios = listOf(
                Studio(1,"Unknown","unknown","unknown")
            )
        }
        if(it.score==null){
            it.score=10.0
        }
        if(it.scoredBy==0){
            it.scoredBy=10
        }
        if(it.rank==null){
            it.rank=10
        }
        if(it.synopsis==null) {
            it.synopsis = "Currently not available"
        }

        it.toSearchAnime()
    }
    LoadResult.Page(
        data = searchList,
        prevKey = null,
        nextKey = nextPage+1
    )
}
catch (e:Exception){
    LoadResult.Error(e)
}

       }


    }
