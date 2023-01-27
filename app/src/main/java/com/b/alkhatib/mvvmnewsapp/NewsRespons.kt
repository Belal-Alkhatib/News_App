package com.b.alkhatib.mvvmnewsapp

data class NewsRespons(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)