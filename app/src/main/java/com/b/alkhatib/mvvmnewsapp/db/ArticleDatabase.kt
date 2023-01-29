package com.b.alkhatib.mvvmnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.b.alkhatib.mvvmnewsapp.models.Article
/**
* l-15 we  don't need to implement it and the implementation of that will happen behind the scenes (room will do that for us )
* l-17 to be able to create our actual database (a.create instance of our actual database )
* l-20 @volatile: meaning that writes to this field are immediately made visible to other threads.
* l-20 @Volatile: that means that other threads can immediately see when a thread changes this instance
*
* */
@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase: RoomDatabase() {

    abstract fun getArticleDoa():ArticleDao

    companion object{
        @Volatile
        private var Instance: ArticleDatabase? = null

        fun getInstance(context:Context):ArticleDatabase{
            val tempInstance = Instance
            if (tempInstance != null){
                return tempInstance
            }
            val instace = Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
                ).fallbackToDestructiveMigration()
                .build()

            Instance = instace
            return instace
        }
    }

}