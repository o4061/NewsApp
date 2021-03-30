package com.userfaltakas.newsapp.repository

import androidx.lifecycle.LiveData
import com.userfaltakas.newsapp.api.RetrofitInstance
import com.userfaltakas.newsapp.constants.Constants.API_KEY
import com.userfaltakas.newsapp.data.Article
import com.userfaltakas.newsapp.data.NewsResponse
import com.userfaltakas.newsapp.database.ArticleDatabase
import retrofit2.Response

class NewsRepository(
    private val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> {
        val filter = mutableMapOf<String, String>()
        filter["country"] = countryCode
        filter["page"] = pageNumber.toString()
        filter["apiKey"] = API_KEY
        return RetrofitInstance.api.getBreakingNews(filter)
    }

    suspend fun searchNews(query: String): Response<NewsResponse> {
        val filter = mutableMapOf<String, String>()
        filter["q"] = query
        filter["page"] = "1"
        filter["apiKey"] = API_KEY

        return RetrofitInstance.api.searchForNews(filter)
    }

    suspend fun upsert(article: Article) {
        db.getArticleDao().upsert(article)
    }

    fun getSavedNews(): LiveData<List<Article>> {
        return db.getArticleDao().getAllArticles()
    }

    suspend fun deleteArticle(article: Article) {
        db.getArticleDao().deleteArticle(article)
    }
}