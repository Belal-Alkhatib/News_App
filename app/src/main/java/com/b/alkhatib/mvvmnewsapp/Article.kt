package com.b.alkhatib.mvvmnewsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "article"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,             //not all artivle will have an id (because not every article will have an id due to the fact that we get alot of articles from retrofit that we don't save into our DB)
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)