package com.kirabium.mynews.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kirabium.mynews.data.NewsRepository
import com.kirabium.mynews.model.Article

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private var newsViewStateLiveData: LiveData<NewsViewState>? = null

    init {
        newsViewStateLiveData =
            Transformations.map(
                newsRepository.getNewsLiveData()
            ) { news: List<Article>? ->  // ... and we transform the data from the server to the ViewState (with a Transformations.map)
                mapDataToViewState(news)
            }
    }

    // This is the "final product" of our ViewModel : every data needed from the view is in this LiveData
    // Only the list of article for the moment
    fun getViewStateLiveData(): LiveData<NewsViewState>? {
        return newsViewStateLiveData
    }

    private fun mapDataToViewState(news: List<Article>?): NewsViewState {
        val newsToBeDisplayed: MutableList<Article> = ArrayList()
        if (news != null) {
            // Mapping data from remote source to view data, ask to your mentor to know why it is important to do so
            for (new in news) {
                newsToBeDisplayed.add(new)
            }
        }
        return NewsViewState(
            newsToBeDisplayed
        )
    }
}