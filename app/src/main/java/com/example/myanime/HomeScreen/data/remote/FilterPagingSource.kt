package com.example.myanime.HomeScreen.data.remote


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animelist.common.Constants
import com.example.animelist.domain.model.Anime
import com.example.myanime.HomeScreen.Mappers.toAnime
import com.example.myanime.HomeScreen.data.remote.ApiFields.Studio
import kotlinx.coroutines.delay

class FilterPagingSource(
    val jikanApi: jikanApi,
    val genres:String
): PagingSource<Int, Anime>() {
    override fun getRefreshKey(state: PagingState<Int, Anime>): Int {
       return Constants.key
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
 return try {
    val nextPage=params.key?:1
     delay(2000L)
    val filterResult = jikanApi.getAnimeFilter(
        genres= genres,
        currentPage = nextPage
    )

    Constants.key = filterResult.pagination.currentPage+1
    val filterList= filterResult.data.map {
        if(it.studios.isEmpty()){
            it.studios = listOf(
                Studio(1,"Unknown","unknown","unknown")
            )
        }
        if(it.score==null){
            it.score= -1.0
        }
        if(it.scoredBy==0){
            it.scoredBy=-1
        }
        if(it.rank==null){
            it.rank=-1
        }
        if(it.synopsis==null) {
            it.synopsis = "Currently not available"
        }

        it.toAnime()
    }
         LoadResult.Page(
             data = filterList,
             prevKey = null,
             nextKey = if (filterResult.pagination.hasNextPage)nextPage + 1 else null
         )

}
catch (e:Exception){
    LoadResult.Error(e)
}

       }


    }
