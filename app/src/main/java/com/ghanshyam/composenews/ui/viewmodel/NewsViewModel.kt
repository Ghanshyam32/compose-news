package com.ghanshyam.composenews.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghanshyam.composenews.dataLayer.AppConstants
import com.ghanshyam.composenews.dataLayer.entity.NewsResponse
import com.ghanshyam.composenews.ui.repositories.NewsRepository
import com.ghanshyam.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {


    private val news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val _news: StateFlow<ResourceState<NewsResponse>> = news

    init {
        getNews(AppConstants.COUNTRY)
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest { newsResponse ->
                    news.value = newsResponse
                }
        }
    }

    companion object {
        const val TAG = "NewsViewModel"
    }
}
