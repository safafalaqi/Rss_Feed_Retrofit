package com.example.rssfeedretrofit

import retrofit2.http.GET
import com.example.rssfeedretrofit.model.Rss
import retrofit2.Call

interface RssAPI {
    @get:GET("news/rss/")
    val rss: Call<Rss?>?

    companion object {
        const val BASE_URL = "https://www.freecodecamp.org/"
    }
}
