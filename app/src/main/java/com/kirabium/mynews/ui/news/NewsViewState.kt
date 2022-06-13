package com.kirabium.mynews.ui.news

import com.kirabium.mynews.model.Article
import java.util.*

// This viewstate is not much worth it since there is only a list, but it's also here where I can handle
// Some other items of the views, like isButtonEnabled, ...
class NewsViewState(private val news: List<Article>) {

    fun getNews(): List<Article> {
        return news
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as NewsViewState
        return news == that.news
    }

    override fun hashCode(): Int {
        return Objects.hash(news)
    }

    override fun toString(): String {
        return "NewsViewState{" +
                "news=" + news +
                '}'
    }
}