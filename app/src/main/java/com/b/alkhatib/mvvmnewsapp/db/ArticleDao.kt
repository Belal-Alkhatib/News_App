package com.b.alkhatib.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.b.alkhatib.mvvmnewsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //onConflict: this strategy determine what happens if that article that we want to insert in that database already exists in our database and in that case we simply want to replace
    suspend fun upsert(article: Article):Long       // which stands for update or insert so it will insert a new article and if it is already in the database it will update it inserted and replace it. Long: which is the id that was inserted

    // this function should return all available articles in our database // why it is not a suspend fun? -> because it will return a LiveData object and that doesnt work with suspend fun
    @Query("SELECT * from article")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)


}