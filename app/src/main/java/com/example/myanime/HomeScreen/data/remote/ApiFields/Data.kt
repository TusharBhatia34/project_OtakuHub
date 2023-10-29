package com.example.myanime.HomeScreen.data.remote.ApiFields


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("aired")
    val aired: Aired,
    @SerializedName("airing")
    val airing: Boolean,

    @SerializedName("duration")
    val duration: String,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("explicit_genres")
    val explicitGenres: List<Any>,
    @SerializedName("favorites")
    val favorites: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("images")
    val images: Images,
    @SerializedName("licensors")
    val licensors: List<Licensor>,
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("members")
    val members: Int,
    @SerializedName("popularity")
    var popularity: Int,
    @SerializedName("producers")
    val producers: List<Producer>,
    @SerializedName("rank")
    var rank: Int,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("score")
    var score: Double,
    @SerializedName("scored_by")
    var scoredBy: Int,
    @SerializedName("season")
    val season: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("studios")
    var studios: List<Studio>,
    @SerializedName("synopsis")
    var synopsis: String,
    @SerializedName("themes")
    val themes: List<Theme>,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String,
    @SerializedName("title_japanese")
    val titleJapanese: String,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    @SerializedName("titles")
    val titles: List<Title>,
    @SerializedName("trailer")
    val trailer: Trailer,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("year")
    val year: Int
)