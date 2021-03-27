package com.userfaltakas.newsapp.api

import com.userfaltakas.newsapp.data.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @QueryMap filter: Map<String, String>
    ): Response<NewsResponse>

    @GET("everything")
    suspend fun searchForNews(
        @QueryMap filter: Map<String, String>
    ): Response<NewsResponse>
}