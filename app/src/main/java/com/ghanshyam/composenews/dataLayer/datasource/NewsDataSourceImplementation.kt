package com.ghanshyam.composenews.dataLayer.datasource

import com.ghanshyam.composenews.dataLayer.api.ApiService
import com.ghanshyam.composenews.dataLayer.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImplementation @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNewsHeadLine(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadLine(country)
    }

}