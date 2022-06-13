package com.kirabium.mynews.ui.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kirabium.mynews.data.NewsRepository
import com.kirabium.mynews.model.Article
import com.kirabium.mynews.ui.LiveDataTestUtils
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private val newsRepository: NewsRepository? = null
    private var viewModel: NewsViewModel? = null


    @Test
    fun nominal_case() {
        // Given
        val newsMutableLiveData = MutableLiveData<List<Article>?>()

        // Mock the method from Repository returning the LiveData
        BDDMockito.given(newsRepository!!.getNewsLiveData()).willReturn(newsMutableLiveData)

        // Set default value to LiveData
        val news = defaultNews
        newsMutableLiveData.value = news
        viewModel = NewsViewModel(newsRepository)

        // When
        LiveDataTestUtils.observeForTesting(
            viewModel!!.getViewStateLiveData()
        ) { liveData: LiveData<NewsViewState?> ->
            // Then
            // Step 1 for Then : assertions...
            TestCase.assertEquals(
                NewsViewState(
                    defaultNews
                ),
                liveData.value
            )

            // ... Step 2 for Then : verify !
            Mockito.verify(newsRepository)!!.getNewsLiveData()
            Mockito.verifyNoMoreInteractions(newsRepository)
        }
    }

    @Test
    fun GIVEN_the_list_is_null_THEN_nothing_is_displayed() {
        // Given
        val nullNewsMutableLiveData = MutableLiveData<List<Article>?>()
        // This LiveData has a value of null
        nullNewsMutableLiveData.value = null
        BDDMockito.given(newsRepository!!.getNewsLiveData()).willReturn(nullNewsMutableLiveData)
        viewModel = NewsViewModel(newsRepository)
        // When
        LiveDataTestUtils.observeForTesting(
            viewModel!!.getViewStateLiveData()
        ) { liveData ->
            // Then
            TestCase.assertEquals(
                NewsViewState(emptyList()),
                liveData.value
            )
            Mockito.verify(newsRepository).getNewsLiveData()
            Mockito.verifyNoMoreInteractions(newsRepository)
        }
    }

    private val defaultNews: List<Article>
        private get() {
            val news: MutableList<Article> = ArrayList()
            for (i in 0 until DEFAULT_NEWS_COUNT) {
                news.add(
                    Article()
                )
            }
            return news
        }

    companion object {
        private const val DEFAULT_NEWS_COUNT = 10
    }
}