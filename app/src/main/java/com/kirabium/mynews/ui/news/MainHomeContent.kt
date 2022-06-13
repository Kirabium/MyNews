package com.kirabium.mynews.ui.news

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kirabium.mynews.model.Article


@Composable
fun MainHomeContent(news: List<Article>) {
    LazyColumn {
        itemsIndexed(items = news) { _, item ->
            ArticleItem(article = item)
        }
    }
}