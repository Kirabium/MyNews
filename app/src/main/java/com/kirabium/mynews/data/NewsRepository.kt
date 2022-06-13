package com.kirabium.mynews.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kirabium.mynews.BuildConfig
import com.kirabium.mynews.model.Article
import com.kirabium.mynews.model.News
import com.kirabium.mynews.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val newsApi: NewsApi) {


    fun getNewsLiveData(): LiveData<List<Article>?> {
        val newsMutableLiveData: MutableLiveData<List<Article>?> =
            MutableLiveData<List<Article>?>()


        newsApi.getListOfNews(apiKey = BuildConfig.API_KEY)
            .enqueue(object : Callback<NewsResponse?> {
                override fun onResponse(
                    call: Call<NewsResponse?>,
                    response: Response<NewsResponse?>
                ) {
                    if (response.body() != null) {
                        newsMutableLiveData.value = response.body()!!.articles
                    }
                }

                override fun onFailure(call: Call<NewsResponse?>, t: Throwable) {
                    newsMutableLiveData.value = null
                }
            })
        return newsMutableLiveData
    }
}