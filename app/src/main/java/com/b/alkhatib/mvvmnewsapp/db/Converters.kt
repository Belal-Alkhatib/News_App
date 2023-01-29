package com.b.alkhatib.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.b.alkhatib.mvvmnewsapp.models.Source

/**
* @TypeConverter -> to tell room that this is a converter function
* fromSource() ->
*       a. return name because we don't want to know about that id is not important
*       b. whenever we get a source then we tell room that it should convert that source to a string by just taking tha name of this source
* after create this class we need to do is to actually tell our database that we want to add these type converters to that so, ---> go to database class (article database) to add an annotation (@TypeConverters(Converters::class))
 * */
class Converters {

    @TypeConverter
    fun fromSource(sourse:Source): String {
        return sourse.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }


}