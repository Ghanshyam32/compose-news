package com.ghanshyam.composenews.ui.repositories

import com.ghanshyam.composenews.dataLayer.datasource.NewsDataSource
import com.ghanshyam.composenews.dataLayer.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return newsDataSource.getNewsHeadLine(country)
    }
}