package com.kirabium.mynews.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {
        private val gson = GsonBuilder().setLenient().create()
        private val httpClient = OkHttpClient.Builder().build()
        private val BASE_URL = "https://newsapi.org/v2/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        fun getNewsApi(): NewsApi {
            return retrofit.create(NewsApi::class.java)
        }
    }
}