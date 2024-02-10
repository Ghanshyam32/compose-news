package com.ghanshyam.composenews.dataLayer.datasource

import com.ghanshyam.composenews.dataLayer.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

   suspend fun getNewsHeadLine(country: String): Response<NewsResponse>
}