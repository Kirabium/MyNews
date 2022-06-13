package com.kirabium.mynews.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.kirabium.mynews.BuildConfig
import com.kirabium.mynews.model.Article
import com.kirabium.mynews.model.NewsResponse
import com.kirabium.mynews.ui.LiveDataTestUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private val catFactsApi: NewsApi? = null

    @InjectMocks
    private val catFactsRepository: NewsRepository? = null

    @Before
    fun setUp() {
        BDDMockito.given(catFactsApi!!.getListOfNews(BuildConfig.API_KEY)).willReturn(mockedCall)
        BDDMockito.given(mockedResponse!!.body()).willReturn(mockedNewsResponse)
        BDDMockito.given(mockedNewsResponse!!.articles).willReturn(mockedNews)
    }

    @Test
    fun nominal_case() {
        // Given
        // Let's call the repository method
        val result: LiveData<List<Article>?> = catFactsRepository!!.getNewsLiveData()

        // Capture the callback waiting for data
        Mockito.verify(catFactsApi!!.getListOfNews(BuildConfig.API_KEY)).enqueue(
            callbackArgumentCaptor!!.capture()
        )

        // When
        // Trigger the response ourselves
        callbackArgumentCaptor.value.onResponse(mockedCall, mockedResponse)

        // Then
        // Assert the result is posted to the LiveData
        LiveDataTestUtils.observeForTesting(
            result
        ) { liveData: LiveData<List<Article>?> ->
            Assert.assertEquals(
                mockedNews,
                liveData.value
            )
        }
    }

    @Test
    fun GIVEN_the_api_call_fails_THEN_livedata_exposes_null() {
        // Given
        // Let's call the repository method
        val result: LiveData<List<Article>?> = catFactsRepository!!.getNewsLiveData()

        // Capture the callback waiting for data
        Mockito.verify(catFactsApi!!.getListOfNews(BuildConfig.API_KEY)).enqueue(
            callbackArgumentCaptor!!.capture()
        )

        // When
        // Trigger the response ourselves
        callbackArgumentCaptor.value.onFailure(
            mockedCall, Mockito.mock(
                Throwable::class.java
            )
        )

        // Then
        // Assert the result is posted to the LiveData
        LiveDataTestUtils.observeForTesting(
            result
        ) { liveData: LiveData<List<Article>?> ->
            Assert.assertNull(
                liveData.value
            )
        }
    }

    @Captor
    private val callbackArgumentCaptor: ArgumentCaptor<Callback<NewsResponse>>? = null

    @Mock
    private val mockedCall: Call<NewsResponse>? = null

    @Mock
    private val mockedResponse: Response<NewsResponse>? = null

    @Mock
    private val mockedNewsResponse: NewsResponse? = null

    @Mock
    private val mockedNews: List<Article>? = null
}