package com.b.alkhatib.mvvmnewsapp.api

import com.b.alkhatib.mvvmnewsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*lazy in Kotlin is useful in a scenario when we want to create an object inside a class, but that object
creation is expensive and that might lead to a delay in the creation of the object that is dependent on that
expensive object.
**/

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor() //حتى نتمكن من معرفة requests التي نقدمها وما هي ال response
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // used to determine how the we response should be interpreted and converted to kotlin object
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }




}
