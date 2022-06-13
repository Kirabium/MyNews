package com.kirabium.mynews.data

import com.kirabium.mynews.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines?country=fr")
    fun getListOfNews(@Query("apiKey") apiKey: String): Call<NewsResponse>
}