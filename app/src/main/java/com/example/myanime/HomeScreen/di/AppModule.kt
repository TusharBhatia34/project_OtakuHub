package com.example.animelist.di


import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.animelist.common.Constants
import com.example.myanime.HomeScreen.data.local.AnimeDatabase
import com.example.myanime.HomeScreen.data.local.AnimeEntity
import com.example.myanime.HomeScreen.data.remote.AnimeRemoteMediator
import com.example.myanime.HomeScreen.data.remote.jikanApi


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAnimeDatabase(@ApplicationContext context:Context):AnimeDatabase{
        return Room.databaseBuilder(context = context
        ,AnimeDatabase::class.java,
        "anime.db"
            ).build()


    }
    @Provides
    @Singleton
    fun provideJikanApi(): jikanApi {
return Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(jikanApi::class.java)
    }

    @Provides
    @Singleton
    fun providePager(animeDb: AnimeDatabase, api: jikanApi):Pager<Int, AnimeEntity>{
        return Pager(
            config = PagingConfig(pageSize = 20),

            pagingSourceFactory = {
                animeDb.dao.pagingSource()
            },
                    remoteMediator = AnimeRemoteMediator(
                    animeDb,api
        )
        )
    }

}