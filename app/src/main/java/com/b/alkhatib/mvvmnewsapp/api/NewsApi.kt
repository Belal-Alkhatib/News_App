package com.b.alkhatib.mvvmnewsapp.api

import com.b.alkhatib.mvvmnewsapp.NewsRespons
import com.b.alkhatib.mvvmnewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsRespons>

    //everything: Because we search for articles, not just breaking news articles
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")   //q: Keywords or phrases to search for in the article title and body.
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsRespons>
}