package com.kirabium.mynews.ui.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.kirabium.mynews.model.Article
import com.kirabium.mynews.ui.ViewModelFactory
import com.kirabium.mynews.ui.news.ui.theme.MyNewsTheme

class MainActivity : ComponentActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, ViewModelFactory.instance!!).get(
                NewsViewModel::class.java
            )

        setContent {
            MyNewsTheme {
                MyLoadingApp()
            }
        }

        viewModel.getViewStateLiveData()!!.observe(this) { news ->
            setContent {
                MyNewsTheme {
                    MyApp(news.getNews())
                }
            }
        }

    }

    @Composable
    private fun MyLoadingApp() {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Fetching the news ...")
                CircularProgressIndicator()
            }
        }
    }


    @Composable
    fun MyApp(news: List<Article>) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "MyNews")
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Gray,
                    elevation = 2.dp
                )
            },
            content = {
                MainHomeContent(news)
            }
        )
    }
}
