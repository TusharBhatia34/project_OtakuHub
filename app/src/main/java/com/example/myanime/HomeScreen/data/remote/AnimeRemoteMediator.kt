package com.example.myanime.HomeScreen.data.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.RoomDatabase
import androidx.room.withTransaction
import com.example.animelist.common.Constants
import com.example.myanime.HomeScreen.Mappers.toAnimeEntity
import com.example.myanime.HomeScreen.data.local.AnimeDatabase
import com.example.myanime.HomeScreen.data.local.AnimeEntity
import com.example.myanime.HomeScreen.data.remote.ApiFields.Studio

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import okhttp3.internal.toImmutableList
import retrofit2.HttpException
import javax.inject.Inject

@ExperimentalPagingApi
class AnimeRemoteMediator @Inject constructor(
    val AnimeDb: AnimeDatabase,
    val jikanApi: jikanApi
):RemoteMediator<Int, AnimeEntity>() {
   override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, AnimeEntity>,
    ): MediatorResult {
       return try {

           val loadkey = when(loadType){
               LoadType.REFRESH ->1
               LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = false)
               LoadType.APPEND -> {
          val pageNo = Constants.name.toInt()
                   pageNo+1
               }
           }

           delay(2000L)
           val anime = jikanApi.getAnimeList(
               currentPage = loadkey,
               pageSize = state.config.pageSize,
               orderBy = "popularity"
           )

Constants.name = anime.pagination.currentPage.toString()
           val animeEntity:List<AnimeEntity> = anime.data.map {
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
               if(it.synopsis==null){
                   it.synopsis="Currently not available"
               }
            it.toAnimeEntity()
           }

           delay(1000L)
              AnimeDb.dao.upsertAll(animeEntity)

            MediatorResult.Success(endOfPaginationReached = !anime.pagination.hasNextPage)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

}