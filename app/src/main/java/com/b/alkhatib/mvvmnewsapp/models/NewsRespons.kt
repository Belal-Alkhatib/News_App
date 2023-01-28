package com.b.alkhatib.mvvmnewsapp.models

data class NewsRespons(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)