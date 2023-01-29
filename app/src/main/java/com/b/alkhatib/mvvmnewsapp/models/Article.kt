package com.b.alkhatib.mvvmnewsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
/**
* id = null -> not all article will have an id (because not every article will have an id due to the fact that we get a lot of articles from retrofit that we don't save into our DB)
* problem -> room xan only handle primitive data types and strings so very basic data type
*           NOT
*           our custom classes ans we need to creat what is called a (type converter to tell room how is should interpret that source class and convert that source class into a string for example)
*           and on other hand
*           if we have  a string you need to tell room how it should create that source class all of that string [[[ for that ]]]-> i create that type convert class (in db package)
* */
@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)