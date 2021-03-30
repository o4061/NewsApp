package com.userfaltakas.newsapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(
    tableName = "articles"
)

@Parcelize
data class Article(
    @PrimaryKey(autoGenerate = false)
    val url: String,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source,
    val title: String?,
    val urlToImage: String?
) : Parcelable