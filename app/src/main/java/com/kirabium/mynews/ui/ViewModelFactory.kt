package com.kirabium.mynews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kirabium.mynews.data.NewsRepository
import com.kirabium.mynews.data.RetrofitService
import com.kirabium.mynews.ui.news.NewsViewModel

class ViewModelFactory private constructor() : ViewModelProvider.Factory {
    // I'll make the injection here since the app is very small and dagger, hilt or koin would be overkilling
    private val newsRepository: NewsRepository =
        NewsRepository( // We inject the NewsApi in the Repository constructor
            RetrofitService.getNewsApi()
        )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            // We inject the Repository in the ViewModel constructor
            return NewsViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        private var factory: ViewModelFactory? = null
        val instance: ViewModelFactory?
            get() {
                if (factory == null) {
                    synchronized(ViewModelFactory::class.java) {
                        if (factory == null) {
                            factory = ViewModelFactory()
                        }
                    }
                }
                return factory
            }
    }

}